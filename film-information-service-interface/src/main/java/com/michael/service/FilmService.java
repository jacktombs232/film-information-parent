package com.michael.service;

import com.michael.group.FilmGroup;
import com.michael.pojo.Film;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface FilmService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Film> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Film film);
	
	
	/**
	 * 修改
	 */
	public void update(Film film);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Film findOne(Long id);
	
	
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
	public PageResult findPage(Film film, int pageNum, int pageSize);





	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(FilmGroup film, int pageNum, int pageSize);


	/**
	 *
	 * @return
	 */
	public Long countNumber();

}
