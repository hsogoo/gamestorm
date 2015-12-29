package com.hsogoo.gamestorm.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangsaigang
 * @time 下午1:20
 */
@Controller
@RequestMapping("/backend")
public class ShoppingController {

    @RequestMapping("/cart")
    public String showCart(Model model){
        return "frontend/shopping/cart";
    }
}
