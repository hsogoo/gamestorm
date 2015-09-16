package com.hsogoo.gamestorm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsogoo.gamestorm.service.user.UserService;
import com.hsogoo.gamestorm.vo.User;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:17:13
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfo/{userId}")
	@ResponseBody
	public User showUserInfo(ModelMap modelMap, @PathVariable Long userId){
		return userService.getUserById(userId);
	}
	
	@RequestMapping("/showUserPage/{userId}")
	public String getUserPage(Model model, @PathVariable Long userId){
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "user";
		
	}
	
}