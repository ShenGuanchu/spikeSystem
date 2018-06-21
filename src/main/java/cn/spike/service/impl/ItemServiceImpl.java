package cn.spike.service.impl;

import cn.spike.mapper.ItemMapper;
import cn.spike.po.Item;
import cn.spike.po.ItemExample;
import cn.spike.po.Page;
import cn.spike.service.CategoryService;
import cn.spike.service.DiscounttypeService;
import cn.spike.service.ItemService;
import cn.spike.service.StoresService;
import cn.spike.vo.VoItem;
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

    @Override
    public List<Item> list(Page page) {
        return itemMapper.selectByExample(new ItemExample());
    }

    @Override
    public void add(Item record) {
        itemMapper.insertSelective(record);
        return;
    }

    @Override
    public void delete(int id) {
        itemMapper.deleteByPrimaryKey(id);
        return;
    }

    @Override
    public void update(Item record) {
        itemMapper.updateByPrimaryKeySelective(record);
        return;
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
