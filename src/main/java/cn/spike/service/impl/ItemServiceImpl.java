package cn.spike.service.impl;

import cn.spike.component.JedisClient;
import cn.spike.mapper.ItemMapper;
import cn.spike.po.Item;
import cn.spike.po.ItemExample;
import cn.spike.po.Page;
import cn.spike.service.CategoryService;
import cn.spike.service.DiscounttypeService;
import cn.spike.service.ItemService;
import cn.spike.service.StoresService;
import cn.spike.util.Constant;
import cn.spike.vo.VoItem;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    StoresService storesService;

    @Autowired
    DiscounttypeService discounttypeService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    JedisClient jedisClient;

    @Override
    public List<Item> list(Page page) {
//        添加缓存
//        优先查询缓存
        try {
            String json = jedisClient.hget(Constant.getConfig("redis_content_key"),
                    Constant.getConfig("item_all_list"));
            List<Item> cacheItemList = JSON.parseArray(json,Item.class);
            if (cacheItemList != null) {
                return cacheItemList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Item> list = itemMapper.selectByExample(new ItemExample());
//        将数据库中的数据存入缓存
        try {
            jedisClient.hset(Constant.getConfig("redis_content_key"),
                    Constant.getConfig("item_all_list"),
                    JSON.toJSONString(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Item record) {
        itemMapper.insertSelective(record);
        clearRedisCache();
        return;
    }

    @Override
    public void delete(int id) {
        itemMapper.deleteByPrimaryKey(id);
        clearRedisCache();
        return;
    }

    @Override
    public void update(Item record) {
        itemMapper.updateByPrimaryKeySelective(record);
        clearRedisCache();
        return;
    }

    private void clearRedisCache() {
        try {
            jedisClient.hdel(Constant.getConfig("redis_content_key"),
                    Constant.getConfig("item_all_list"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item selectByPrimaryKey(int id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<VoItem> vo(List<Item> list) {
        List<VoItem> list1 = new ArrayList<>();
        for (Item item:
                list) {
            VoItem voItem = new VoItem(item);
            voItem.setVoCategory(categoryService.selectByPrimaryKey(voItem.getCategory()).getName());
            voItem.setVoDiscounttype(discounttypeService.selectByPrimaryKey(voItem.getDiscounttype()).getName());
            voItem.setVoStores(storesService.selectByPrimaryKey(voItem.getStores()).getName());
            list1.add(voItem);
        }
        return list1;
    }
}
