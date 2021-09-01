package com.michael.service;

import com.michael.pojo.User;
import com.michael.pojo.UserDesc;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UserDescService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<UserDesc> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);


	/**
	 * 修改
	 */
	public void update(UserDesc user);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public UserDesc findOne(Long id);
	


	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(UserDesc user, int pageNum, int pageSize);
	
}
