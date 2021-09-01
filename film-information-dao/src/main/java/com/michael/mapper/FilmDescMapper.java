package com.michael.mapper;

import com.michael.pojo.FilmDesc;
import com.michael.pojo.FilmDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmDescMapper {
    long countByExample(FilmDescExample example);

    int deleteByExample(FilmDescExample example);

    int deleteByFilmId(Long id);

    FilmDesc selectByFilmId(Long id);

    int insert(FilmDesc record);

    int insertSelective(FilmDesc record);

    int updateByFilmDesc(FilmDesc filmDesc);

    List<FilmDesc> selectByExample(FilmDescExample example);

    int updateByExampleSelective(@Param("record") FilmDesc record, @Param("example") FilmDescExample example);


    int updateByExample(@Param("record") FilmDesc record, @Param("example") FilmDescExample example);

}