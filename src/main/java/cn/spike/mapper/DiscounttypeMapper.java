package cn.spike.mapper;

import cn.spike.po.Discounttype;
import cn.spike.po.DiscounttypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscounttypeMapper {
    long countByExample(DiscounttypeExample example);

    int deleteByExample(DiscounttypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Discounttype record);

    int insertSelective(Discounttype record);

    List<Discounttype> selectByExample(DiscounttypeExample example);

    Discounttype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Discounttype record, @Param("example") DiscounttypeExample example);

    int updateByExample(@Param("record") Discounttype record, @Param("example") DiscounttypeExample example);

    int updateByPrimaryKeySelective(Discounttype record);

    int updateByPrimaryKey(Discounttype record);
}