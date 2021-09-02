package com.michael.controller;

import com.michael.pojo.User;
import com.michael.service.UserService;
import com.michael.util.Email;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<User> findAll(){
		List<User> list = userService.findAll();
		return list;
	}

	/**
	 * 增加
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody User user){
		try {
			User test = new User();
			test.setEmail(user.getEmail());
			test = userService.findOne(test);
			if(test!=null){
				return new Result(false,"邮箱已经注册");
			}

			userService.add(user);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody User user){
		try {
			userService.update(user);
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
	public User findOne(Long id){
		return userService.findOne(id);
	}

	/**
	 *
	 * @param email
	 * @return
	 */
	@RequestMapping("/SetCode")
	public Result SetCode(String email){
		try {
			String Code = getRandomString(5).toUpperCase();

			redisTemplate.boundValueOps(email).set(Code);
			redisTemplate.expire(email, 5, TimeUnit.MINUTES);

			Email emails = new Email();
			emails.sendEmail(email, Code);
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,"发送失败");
		}
		return new Result(true,"发送成功");
	}


	@RequestMapping("/verification")
	public Result verification(String Code,@RequestBody User user){
		if(redisTemplate.boundValueOps(user.getEmail()).get().equals(Code)){
			String password = user.getUserPassword();
			user.setUserPassword(null);
			user=userService.findOne(user);
			user.setUserPassword(password);
			userService.update(user);
			return new Result(true,"验证成功");
		}
		return new Result(false,"验证码或者邮箱错误");
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			userService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param user
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody User user, int page, int rows  ){
		return userService.findPage(user, page, rows);		
	}



	//length用户要求产生字符串的长度
	public static String getRandomString(int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number=random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
}
