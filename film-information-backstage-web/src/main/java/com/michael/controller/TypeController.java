package com.michael.controller;

import com.michael.pojo.FilmType;
import com.michael.service.FilmTypeService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private FilmTypeService typeService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<FilmType> findAll(){
		return typeService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return typeService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param type
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody FilmType type){
		try {
			typeService.add(type);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param type
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody FilmType type){
		try {
			typeService.update(type);
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
	public FilmType findOne(Long id){
		return typeService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			typeService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody FilmType type, int page, int rows  ){
		return typeService.findPage(type, page, rows);		
	}


	@RequestMapping("findfilmTypeList")
	public List<Map> findfilmTypeList(){
		return typeService.findfilmTypeList();
	}
	
}
