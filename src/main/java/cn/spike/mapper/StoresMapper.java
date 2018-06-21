package cn.spike.mapper;

import cn.spike.po.Stores;
import cn.spike.po.StoresExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoresMapper {
    long countByExample(StoresExample example);

    int deleteByExample(StoresExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stores record);

    int insertSelective(Stores record);

    List<Stores> selectByExample(StoresExample example);

    Stores selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Stores record, @Param("example") StoresExample example);

    int updateByExample(@Param("record") Stores record, @Param("example") StoresExample example);

    int updateByPrimaryKeySelective(Stores record);

    int updateByPrimaryKey(Stores record);
}