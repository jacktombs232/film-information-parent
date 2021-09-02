package com.michael.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.michael.mapper.FilmTypeMapper;
import com.michael.pojo.FilmType;
import com.michael.pojo.FilmTypeExample;
import com.michael.service.FilmTypeService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FilmTypeServiceImpl implements FilmTypeService {

	@Autowired
	private FilmTypeMapper typeMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<FilmType> findAll() {
		return typeMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<FilmType> page=   (Page<FilmType>) typeMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(FilmType type) {
		typeMapper.insert(type);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(FilmType type){
		typeMapper.updateByPrimaryKey(type);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public FilmType findOne(Long id){
		return typeMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			typeMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(FilmType type, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		FilmTypeExample example=new FilmTypeExample();
		FilmTypeExample.Criteria criteria = example.createCriteria();
		
		if(type!=null){			
						if(type.getTypeName()!=null && type.getTypeName().length()>0){
				criteria.andTypeNameLike("%"+type.getTypeName()+"%");
			}
	
		}
		
		Page<FilmType> page= (Page<FilmType>)typeMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> findfilmTypeList() {
		return typeMapper.findfilmTypeList();
	}

	@Override
	public Long countNumber() {
		return typeMapper.countByExample(null);
	}


}
