package cn.spike.service;

import cn.spike.po.Item;
import cn.spike.po.Page;
import cn.spike.vo.VoItem;

import java.util.List;

/**
 * Created by Ww on 2018/6/18.
 */
public interface ItemService {

    List<Item> list(Page page);

    void add(Item record);

    void delete(int id);

    void update(Item record);

    Item selectByPrimaryKey(int id);

    List<VoItem> vo(List<Item> list);
}
