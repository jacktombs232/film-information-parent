package com.michael.service;

import com.michael.pojo.Evaluate;
import com.michael.pojo.User;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface EvaluateService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Evaluate> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Evaluate evaluate);

	

	/**
	 * 根据ID获取实体
	 * @param evaluate_id
	 * @return
	 */
	public Evaluate findOne(Long evaluate_id);


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
	public PageResult findPage(Evaluate evaluate, int pageNum, int pageSize);


	/**
	 *
	 * @return
	 */
	public Long countNumber();
	
}
