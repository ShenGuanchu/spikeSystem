package cn.spike.service.impl;

import cn.spike.mapper.DiscounttypeMapper;
import cn.spike.po.Discounttype;
import cn.spike.po.DiscounttypeExample;
import cn.spike.po.Page;
import cn.spike.service.DiscounttypeService;
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
        return;
    }

    @Override
    public void update(Discounttype record) {
        discounttypeMapper.updateByPrimaryKeySelective(record);
        return;
    }

    @Override
    public Discounttype selectByPrimaryKey(int id) {
        return discounttypeMapper.selectByPrimaryKey(id);
    }
}
