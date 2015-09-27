package com.hsogoo.gamestorm.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.order.OrderService;
import com.hsogoo.gamestorm.vo.Order;

/**
 * @author hsogoo
 * @time 2015-9-27 下午09:17:30
 * @description
 */
@Controller
@RequestMapping("/backend/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/manage")
	public ModelAndView getGamePage(ModelAndView model){
		List<Order> orderList = orderService.getAllOrderList();
		model.setViewName("/backend/order/orderManager");
		model.addObject("orderList", orderList);
		return model;
	}
}
