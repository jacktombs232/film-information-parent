package com.michael.mapper;

import com.michael.pojo.UserDesc;
import com.michael.pojo.UserDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDescMapper {
    long countByExample(UserDescExample example);

    int deleteByExample(UserDescExample example);

    int deleteByPrimaryKey(Long userId);


    int insert(UserDesc record);

    int insertSelective(UserDesc record);

    List<UserDesc> selectByExample(UserDescExample example);

    UserDesc selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserDesc record, @Param("example") UserDescExample example);

    int updateByExample(@Param("record") UserDesc record, @Param("example") UserDescExample example);

    int updateByPrimaryKeySelective(UserDesc record);

    int updateByPrimaryKey(UserDesc record);
}