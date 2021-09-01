package com.michael.controller;

import com.michael.pojo.FilmDesc;
import com.michael.service.FilmDescService;
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
@RequestMapping("/filmDesc")
public class FilmDescController {

	@Autowired
	private FilmDescService filmDescService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<FilmDesc> findAll(){
		return filmDescService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return filmDescService.findPage(page, rows);
	}

	
	/**
	 * 修改
	 * @param film
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody FilmDesc film){
		try {
			filmDescService.update(film);
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
	public FilmDesc findOne(Long id){
		return filmDescService.findOne(id);
	}

	
		/**
	 * 查询+分页
	 * @param film
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody FilmDesc film, int page, int rows  ){
		return filmDescService.findPage(film, page, rows);
	}
	
}
