package cn.spike.service;

import cn.spike.po.Category;
import cn.spike.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
public interface CategoryService {

    List<Category> list(Page page);

    void add(Category record);

    void delete(int id);

    void update(Category record);

    Category selectByPrimaryKey(int id);
}
