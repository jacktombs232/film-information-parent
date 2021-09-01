package com.michael.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.michael.mapper.AdminstratorMapper;
import com.michael.pojo.Adminstrator;
import com.michael.pojo.AdminstratorExample;
import com.michael.service.AdminstratorService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AdminstratorServiceImpl implements AdminstratorService {

	@Autowired
	private AdminstratorMapper adminstratorMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Adminstrator> findAll() {
		return adminstratorMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Adminstrator> page=   (Page<Adminstrator>) adminstratorMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Adminstrator adminstrator) {
		adminstratorMapper.insert(adminstrator);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Adminstrator adminstrator){
		adminstratorMapper.updateByPrimaryKey(adminstrator);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Adminstrator findOne(Long id){
		return adminstratorMapper.selectByPrimaryKey(id);
	}

	@Override
	public Adminstrator findOne(String adminName) {
		return adminstratorMapper.selectByAdminName(adminName);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			adminstratorMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Adminstrator adminstrator, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		AdminstratorExample example=new AdminstratorExample();
		AdminstratorExample.Criteria criteria = example.createCriteria();
		
		if(adminstrator!=null){			
						if(adminstrator.getAdminName()!=null && adminstrator.getAdminName().length()>0){
				criteria.andAdminNameLike("%"+adminstrator.getAdminName()+"%");
			}
			if(adminstrator.getAdminPassword()!=null && adminstrator.getAdminPassword().length()>0){
				criteria.andAdminPasswordLike("%"+adminstrator.getAdminPassword()+"%");
			}
	
		}
		
		Page<Adminstrator> page= (Page<Adminstrator>)adminstratorMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
