package com.hsogoo.gamestorm.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.user.UserService;
import com.hsogoo.gamestorm.vo.UserLevel;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:17:13
 * @description
 */
@Controller
@RequestMapping("/backend/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	// @RequestMapping("/showInfo/{userId}")
	// @ResponseBody
	// public User showUserInfo(ModelMap modelMap, @PathVariable Long userId){
	// 	return userService.getUserById(userId);
	// }
	
	// @RequestMapping("/showUserPage/{userId}")
	// public String getUserPage(Model model, @PathVariable Long userId){
	// 	User user = userService.getUserById(userId);
	// 	model.addAttribute("user", user);
	// 	return "user";
		
	// }
	
	@RequestMapping("/manage")
	public String getUserPage(ModelAndView model){
		return "/backend/user/userManager";
	}
	
	@RequestMapping("/userList")
	@ResponseBody
	public ModelAndView getUserList(ModelAndView model,@RequestParam (value ="page") String page){
		int pageSize = 10;
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(page);
		}catch (Exception e) {
			currentPage = 1;
		}
		List<User> userList = userService.getPageUserList(currentPage, pageSize);
		Long totalCount = userService.getTotalUserCount();
		model.setViewName("/backend/user/userList");
		model.addObject("currentPage", page);
		model.addObject("totalPage", (totalCount -1) / pageSize + 1 );
		model.addObject("userList", userList);
		return model;
	}

	@RequestMapping("/levelSetting")
	public ModelAndView getGamePage(ModelAndView model){
		List<UserLevel> userLevelList = gameService.getAllUserLevelList();
		model.setViewName("/backend/user/userLevelSetting");
		model.addObject("userLevelList", userLevelList);
		return model;
	}
	
}