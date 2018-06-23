package cn.spike.service.impl;

import cn.spike.component.JedisClient;
import cn.spike.mapper.StoresMapper;
import cn.spike.po.Category;
import cn.spike.po.Stores;
import cn.spike.po.StoresExample;
import cn.spike.po.Page;
import cn.spike.service.StoresService;
import cn.spike.util.Constant;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
@Service("storesService")
public class StoresServiceImpl implements StoresService {

    @Autowired
    StoresMapper storesMapper;

    @Autowired
    JedisClient jedisClient;

    @Override
    public List<Stores> list(Page page) {
        return storesMapper.selectByExample(new StoresExample());
    }

    @Override
    public void add(Stores record) {
        storesMapper.insertSelective(record);
        return;
    }

    @Override
    public void delete(int id) {
        storesMapper.deleteByPrimaryKey(id);
        try {
            jedisClient.hdel(Constant.getConfig("stores_id"),id+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void update(Stores record) {
        storesMapper.updateByPrimaryKeySelective(record);
        try {
            jedisClient.hdel(Constant.getConfig("stores_id"),record.getId()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public Stores selectByPrimaryKey(int id) {
        try {
            String cache = jedisClient.hget(Constant.getConfig("stores_id"),
                    id+"");
            Stores stores = JSON.parseObject(cache,Stores.class);
            if (stores != null) {
                return stores;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stores stores = storesMapper.selectByPrimaryKey(id);
        try {
            jedisClient.hset(Constant.getConfig("stores_id"),id+"",JSON.toJSONString(stores));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stores;
    }
}
