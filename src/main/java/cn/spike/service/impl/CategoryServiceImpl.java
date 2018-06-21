package cn.spike.service.impl;

import cn.spike.mapper.CategoryMapper;
import cn.spike.po.Category;
import cn.spike.po.CategoryExample;
import cn.spike.po.Page;
import cn.spike.service.CategoryService;
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
        return;
    }

    @Override
    public void update(Category record) {
        categoryMapper.updateByPrimaryKeySelective(record);
        return;
    }

    @Override
    public Category selectByPrimaryKey(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
