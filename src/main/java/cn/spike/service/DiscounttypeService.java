package cn.spike.service;

import cn.spike.po.Discounttype;
import cn.spike.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
public interface DiscounttypeService {

    List<Discounttype> list(Page page);

    void add(Discounttype record);

    void delete(int id);

    void update(Discounttype record);

    Discounttype selectByPrimaryKey(int id);
}
