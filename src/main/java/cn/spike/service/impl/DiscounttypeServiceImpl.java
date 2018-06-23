package cn.spike.service.impl;

import cn.spike.component.JedisClient;
import cn.spike.mapper.DiscounttypeMapper;
import cn.spike.po.Category;
import cn.spike.po.Discounttype;
import cn.spike.po.DiscounttypeExample;
import cn.spike.po.Page;
import cn.spike.service.DiscounttypeService;
import cn.spike.util.Constant;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
@Service("discounttypeService")
public class DiscounttypeServiceImpl implements DiscounttypeService {

    @Autowired
    DiscounttypeMapper discounttypeMapper;

    @Autowired
    JedisClient jedisClient;

    @Override
    public List<Discounttype> list(Page page) {
        return discounttypeMapper.selectByExample(new DiscounttypeExample());
    }

    @Override
    public void add(Discounttype record) {
        discounttypeMapper.insertSelective(record);
        return;
    }

    @Override
    public void delete(int id) {
        discounttypeMapper.deleteByPrimaryKey(id);
        try {
            jedisClient.hdel(Constant.getConfig("discounttype_id"),id+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void update(Discounttype record) {
        discounttypeMapper.updateByPrimaryKeySelective(record);
        try {
            jedisClient.hdel(Constant.getConfig("discounttype_id"),record.getId()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public Discounttype selectByPrimaryKey(int id) {
        try {
            String cache = jedisClient.hget(Constant.getConfig("discounttype_id"),
                    id+"");
            Discounttype discounttype = JSON.parseObject(cache,Discounttype.class);
            if (discounttype != null) {
                return discounttype;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Discounttype discounttype = discounttypeMapper.selectByPrimaryKey(id);
        try {
            jedisClient.hset(Constant.getConfig("discounttype_id"),id+"",JSON.toJSONString(discounttype));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discounttype;
    }
}
