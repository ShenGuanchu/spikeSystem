package cn.spike.service.impl;

import cn.spike.component.JedisClient;
import cn.spike.mapper.CategoryMapper;
import cn.spike.po.Category;
import cn.spike.po.CategoryExample;
import cn.spike.po.Page;
import cn.spike.service.CategoryService;
import cn.spike.util.Constant;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    JedisClient jedisClient;

    @Override
    public List<Category> list(Page page) {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void add(Category record) {
        categoryMapper.insertSelective(record);
        return;
    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
//        注意位置，必须在对数据库修改成功（未抛出异常）后，对缓存进行修改
        try {
            jedisClient.hdel(Constant.getConfig("category_id"),id+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void update(Category record) {
        categoryMapper.updateByPrimaryKeySelective(record);
        try {
            jedisClient.hdel(Constant.getConfig("category_id"),record.getId()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public Category selectByPrimaryKey(int id) {
        try {
            String cache = jedisClient.hget(Constant.getConfig("category_id"),
                    id+"");
            Category category = JSON.parseObject(cache,Category.class);
            if (category != null) {
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Category category = categoryMapper.selectByPrimaryKey(id);
        try {
            jedisClient.hset(Constant.getConfig("category_id"),id+"",JSON.toJSONString(category));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
