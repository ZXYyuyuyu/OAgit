package com.dwz.xietongoa.mapper;

import com.dwz.xietongoa.model.Positions;
import com.dwz.xietongoa.model.PositionsExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PositionsMapper {
    long countByExample(PositionsExample example);

    int deleteByExample(PositionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Positions record);

    int insertSelective(Positions record);

    List<Positions> selectByExample(PositionsExample example);

    Positions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Positions record, @Param("example") PositionsExample example);

    int updateByExample(@Param("record") Positions record, @Param("example") PositionsExample example);

    int updateByPrimaryKeySelective(Positions record);

    int updateByPrimaryKey(Positions record);
}