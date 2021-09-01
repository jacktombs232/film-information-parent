package com.michael.service;

import com.michael.pojo.Adminstrator;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface AdminstratorService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Adminstrator> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Adminstrator adminstrator);
	
	
	/**
	 * 修改
	 */
	public void update(Adminstrator adminstrator);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Adminstrator findOne(Long id);


	/**
	 * 根据adminName获取实体
	 * @param adminName
	 * @return
	 */
	public Adminstrator findOne(String adminName);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Adminstrator adminstrator, int pageNum, int pageSize);
	
}
