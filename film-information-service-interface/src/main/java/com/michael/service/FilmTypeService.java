package com.michael.service;

import com.michael.pojo.FilmType;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface FilmTypeService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<FilmType> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(FilmType type);
	
	
	/**
	 * 修改
	 */
	public void update(FilmType type);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public FilmType findOne(Long id);
	
	
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
	public PageResult findPage(FilmType type, int pageNum, int pageSize);


	/**
	 * 查询下拉列表数据
	 * @return
	 */
	public  List<Map> findfilmTypeList();


	/**
	 *
	 * @return
	 */
	public Long countNumber();


}
