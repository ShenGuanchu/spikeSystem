package cn.spike.service.impl;

import cn.spike.mapper.StoresMapper;
import cn.spike.po.Stores;
import cn.spike.po.StoresExample;
import cn.spike.po.Page;
import cn.spike.service.StoresService;
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
        return;
    }

    @Override
    public void update(Stores record) {
        storesMapper.updateByPrimaryKeySelective(record);
        return;
    }

    @Override
    public Stores selectByPrimaryKey(int id) {
        return storesMapper.selectByPrimaryKey(id);
    }
}
