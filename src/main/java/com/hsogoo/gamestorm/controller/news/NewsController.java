package com.hsogoo.gamestorm.controller.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.news.NewsService;
import com.hsogoo.gamestorm.vo.News;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:17:13
 * @description
 */
@Controller
@RequestMapping("/backend/news")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/manage")
	public String getUserPage(ModelAndView model){
		return "/backend/news/newsManager";
	}
	
	@RequestMapping("/newsList")
	@ResponseBody
	public ModelAndView getUserList(ModelAndView model,	@RequestParam (value ="page") String page){
		int pageSize = 10;
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(page);
		}catch (Exception e) {
			currentPage = 1;
		}
		List<News> newsList = newsService.getPageNewsList(currentPage, pageSize);
		Long totalCount = newsService.getTotalNewsCount();
		model.setViewName("/backend/news/newsList");
		model.addObject("currentPage", page);
		model.addObject("totalPage", (totalCount -1) / pageSize + 1 );
		model.addObject("newsList", newsList);
		return model;
	}

}