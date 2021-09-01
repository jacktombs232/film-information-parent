package com.michael.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.michael.mapper.UserDescMapper;
import com.michael.pojo.*;
import com.michael.service.UserDescService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDescServiceImpl implements UserDescService {

    @Autowired
    private UserDescMapper userDescMapper;

    @Override
    public List<UserDesc> findAll() {
        return userDescMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<UserDesc> page=  (Page<UserDesc>) userDescMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void update(UserDesc user) {
        userDescMapper.updateByPrimaryKey(user);
    }

    @Override
    public UserDesc findOne(Long id) {
        return userDescMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(UserDesc user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        UserDescExample example=new UserDescExample();
        UserDescExample.Criteria criteria = example.createCriteria();

        if(user!=null){
            if(user.getHeadPortrait()!=null && user.getHeadPortrait().length()>0){
                criteria.andHeadPortraitEqualTo("%"+user.getHeadPortrait()+"%");
            }
            if (user.getCreateDate()!=null){
                criteria.andCreateDateEqualTo(user.getCreateDate());
            }
        }

        Page<UserDesc> page= (Page<UserDesc>)userDescMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
