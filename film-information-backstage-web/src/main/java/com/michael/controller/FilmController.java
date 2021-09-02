package com.michael.controller;

import com.michael.pojo.Film;
import com.michael.service.FilmService;
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
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Film> findAll(){
		return filmService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return filmService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param film
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Film film){
		try {
			filmService.add(film);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param film
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Film film){
		try {
			filmService.update(film);
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
	public Film findOne(Long id){
		return filmService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			filmService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param film
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Film film, int page, int rows  ){
		return filmService.findPage(film, page, rows);		
	}


	@RequestMapping("/countNumber")
	public Long countNumber(){
		return filmService.countNumber();
	}
	
}
