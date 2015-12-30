package com.hsogoo.gamestorm.controller.frontend;

import com.hsogoo.gamestorm.constant.NormalConstant;
import com.hsogoo.gamestorm.util.SessionUtil;
import com.hsogoo.gamestorm.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hsogoo
 * @time 2015-11-21 下午06:25:04
 * @description
 */
@Controller
public class StoreController {
	
	@RequestMapping("/index")
	@ResponseBody
	public ModelAndView getIndexPage(ModelAndView model){
		User user = (User) SessionUtil.getSessionUser();
		if(user != null){
			model.addObject("userName", user.getUserName());
		}
		model.setViewName("frontend/index");
		return model;
	}

	@RequestMapping("/login")
	public String getLoginPage(Model model){
		return "frontend/login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		if(user != null && StringUtils.isNoneBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())){
			User loginUser = new User();
			loginUser.setId(123456L);
			loginUser.setUserName(user.getUserName());
			loginUser.setPassword(user.getPassword());
			session.setAttribute(NormalConstant.USER_LOGIN_KEY, loginUser);
		}
		return "frontend/index";
	}

	@RequestMapping("/logout")
	public String doLogout(Model model){
		return "frontend/login";
	}

}
