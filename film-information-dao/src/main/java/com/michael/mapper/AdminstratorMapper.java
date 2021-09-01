package com.michael.mapper;

import com.michael.pojo.Adminstrator;
import com.michael.pojo.AdminstratorExample;
import com.michael.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminstratorMapper {
    long countByExample(AdminstratorExample example);

    int deleteByExample(AdminstratorExample example);

    int deleteByPrimaryKey(Long adminId);

    int insert(Adminstrator record);

    int insertSelective(Adminstrator record);

    List<Adminstrator> selectByExample(AdminstratorExample example);

    Adminstrator selectByPrimaryKey(Long adminId);

    Adminstrator selectByAdminName(String userName);

    int updateByExampleSelective(@Param("record") Adminstrator record, @Param("example") AdminstratorExample example);

    int updateByExample(@Param("record") Adminstrator record, @Param("example") AdminstratorExample example);

    int updateByPrimaryKeySelective(Adminstrator record);

    int updateByPrimaryKey(Adminstrator record);
}