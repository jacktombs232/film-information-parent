package com.michael.service;

import com.michael.pojo.Film;
import com.michael.pojo.FilmDesc;
import entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface FilmDescService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<FilmDesc> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	

	/**
	 * 修改
	 */
	public void update(FilmDesc film);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public FilmDesc findOne(Long id);
	
	

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(FilmDesc film, int pageNum, int pageSize);
	
}
