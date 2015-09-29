package com.hsogoo.gamestorm.service.news.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.news.NewsDao;
import com.hsogoo.gamestorm.service.news.NewsService;
import com.hsogoo.gamestorm.vo.News;

/**
 * @author hsogoo
 * @time 2015-9-29 下午09:43:16
 * @description
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	@Override
	public List<News> getPageNewsList(int currentPage, int pageSize) {
		return newsDao.getPageNewsList(currentPage, pageSize);
	}

	@Override
	public Long getTotalNewsCount() {
		return newsDao.getTotalNewsCount();
	}

}
