package com.michael.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.michael.mapper.EvaluateMapper;
import com.michael.mapper.UserDescMapper;
import com.michael.mapper.UserMapper;
import com.michael.pojo.FilmDesc;
import com.michael.pojo.User;
import com.michael.pojo.UserDesc;
import com.michael.pojo.UserExample;
import com.michael.service.UserService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;



	@Autowired
	private UserDescMapper userDescMapper;


	@Autowired
	private EvaluateMapper evaluateMapper;

	
	/**
	 * 查询全部
	 */
	@Override
	public List<User> findAll() {
		return userMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<User> page=   (Page<User>) userMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(User user) {
		user.setStatus("0");
		userMapper.insert(user);

		UserDesc userDesc = new UserDesc();
		userDesc.setUserId(user.getUserId());
		userDesc.setCreateDate(new Date());
		userDescMapper.insert(userDesc);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(User user){
		userMapper.updateByPrimaryKey(user);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public User findOne(Long id){
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User findOne(String userName) {
		return userMapper.selectByUsername(userName);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			userMapper.deleteByPrimaryKey(id);

			userDescMapper.deleteByPrimaryKey(id);

			evaluateMapper.deleteByUserId(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(User user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		UserExample example=new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		
		if(user!=null){			
						if(user.getUserName()!=null && user.getUserName().length()>0){
				criteria.andUserNameLike("%"+user.getUserName()+"%");
			}
			if(user.getUserPassword()!=null && user.getUserPassword().length()>0){
				criteria.andUserPasswordLike("%"+user.getUserPassword()+"%");
			}
			if(user.getNicknmae()!=null && user.getNicknmae().length()>0){
				criteria.andNicknmaeLike("%"+user.getNicknmae()+"%");
			}
			if(user.getEmail()!=null && user.getEmail().length()>0){
				criteria.andEmailLike("%"+user.getEmail()+"%");
			}
			if(user.getRemarks()!=null && user.getRemarks().length()>0){
				criteria.andRemarksLike("%"+user.getRemarks()+"%");
			}
	
		}
		
		Page<User> page= (Page<User>)userMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public User findOne(User user) {
		UserExample example=new UserExample();
		UserExample.Criteria criteria = example.createCriteria();

		if(user!=null){
			if(user.getUserName()!=null && user.getUserName().length()>0){
				criteria.andUserNameLike("%"+user.getUserName()+"%");
			}
			if(user.getUserPassword()!=null && user.getUserPassword().length()>0){
				criteria.andUserPasswordLike("%"+user.getUserPassword()+"%");
			}
			if(user.getNicknmae()!=null && user.getNicknmae().length()>0){
				criteria.andNicknmaeLike("%"+user.getNicknmae()+"%");
			}
			if(user.getEmail()!=null && user.getEmail().length()>0){
				criteria.andEmailLike("%"+user.getEmail()+"%");
			}
			if(user.getRemarks()!=null && user.getRemarks().length()>0){
				criteria.andRemarksLike("%"+user.getRemarks()+"%");
			}

		}

		return userMapper.selectByExample(example).get(0);
	}


}
