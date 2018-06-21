package cn.spike.service;

import cn.spike.po.Stores;
import cn.spike.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
public interface StoresService {

    List<Stores> list(Page page);

    void add(Stores record);

    void delete(int id);

    void update(Stores record);

    Stores selectByPrimaryKey(int id);
}
