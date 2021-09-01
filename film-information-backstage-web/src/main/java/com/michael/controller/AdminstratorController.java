package com.michael.controller;

import com.michael.pojo.Adminstrator;
import com.michael.service.AdminstratorService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/adminstrator")
public class AdminstratorController {

	@Autowired
	private AdminstratorService adminstratorService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Adminstrator> findAll(){
		return adminstratorService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return adminstratorService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param adminstrator
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Adminstrator adminstrator){
		try {
			adminstratorService.add(adminstrator);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param adminstrator
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Adminstrator adminstrator){
		try {
			adminstratorService.update(adminstrator);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Adminstrator findOne(Long id){
		return adminstratorService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			adminstratorService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param adminstrator
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Adminstrator adminstrator, int page, int rows  ){
		return adminstratorService.findPage(adminstrator, page, rows);		
	}
	
}
