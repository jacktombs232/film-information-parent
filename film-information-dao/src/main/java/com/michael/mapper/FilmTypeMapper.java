package com.michael.mapper;

import com.michael.pojo.FilmType;
import com.michael.pojo.FilmTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FilmTypeMapper {
    long countByExample(FilmTypeExample example);

    int deleteByExample(FilmTypeExample example);

    int deleteByPrimaryKey(Long typeId);

    int insert(FilmType record);

    int insertSelective(FilmType record);

    List<FilmType> selectByExample(FilmTypeExample example);

    FilmType selectByPrimaryKey(Long typeId);

    int updateByExampleSelective(@Param("record") FilmType record, @Param("example") FilmTypeExample example);

    int updateByExample(@Param("record") FilmType record, @Param("example") FilmTypeExample example);

    int updateByPrimaryKeySelective(FilmType record);

    int updateByPrimaryKey(FilmType record);

    List<Map> findfilmTypeList();
}