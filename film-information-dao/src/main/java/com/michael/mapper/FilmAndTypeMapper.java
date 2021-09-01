package com.michael.mapper;

import com.michael.pojo.FilmAndType;
import com.michael.pojo.FilmAndTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmAndTypeMapper {
    long countByExample(FilmAndTypeExample example);

    int deleteByExample(FilmAndTypeExample example);

    int insert(FilmAndType record);

    int insertSelective(FilmAndType record);

    List<FilmAndType> selectByExample(FilmAndTypeExample example);

    int updateByExampleSelective(@Param("record") FilmAndType record, @Param("example") FilmAndTypeExample example);

    int updateByExample(@Param("record") FilmAndType record, @Param("example") FilmAndTypeExample example);
}