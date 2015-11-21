package com.hsogoo.gamestorm.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hsogoo
 * @time 2015-11-21 下午06:25:04
 * @description
 */
@Controller
public class StoreController {
	
	@RequestMapping("/index")
	public String getUserPage(Model model){
		return "frontend/index";
	}
	
}
