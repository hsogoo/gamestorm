package com.hsogoo.gamestorm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.vo.User;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:17:13
 * @description
 */
@Controller
@RequestMapping("/backend")
public class BackendMainController {

	
	@RequestMapping("/login")
	public String getUserPage(Model model){
		return "backend/login";
		
	}
	
	@RequestMapping("/index")
	public String mainIndex(Model model){
		return "backend/index";
	}
	
	@RequestMapping("/order")
	public String order(Model model){
		return "backend/order";
	}
	
	@RequestMapping("/orderList")
	@ResponseBody
	public ModelAndView orderList(ModelAndView model){
		model.setViewName("backend/orderList");
		return model;
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public List<User> getUser(Model model){
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1L);
		user1.setUserName("hsogoo");
		user1.setPassword("123444");
		User user2 = new User();
		user2.setId(1L);
		user2.setUserName("hunhun");
		user2.setPassword("123444");
		User user3 = new User();
		user3.setId(3L);
		user3.setUserName("qinli");
		user3.setPassword("123444");
		User user4 = new User();
		user4.setId(4L);
		user4.setUserName("xiaohuang");
		user4.setPassword("123444");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		return users;
	}
	
}