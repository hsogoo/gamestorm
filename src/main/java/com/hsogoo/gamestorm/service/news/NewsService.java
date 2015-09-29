package com.hsogoo.gamestorm.service.news;

import java.util.List;

import com.hsogoo.gamestorm.vo.News;

/**
 * @author hsogoo
 * @time 2015-9-29 下午09:42:19
 * @description
 */
public interface NewsService {

	public List<News> getPageNewsList(int currentPage, int pageSize);

	public Long getTotalNewsCount();

}
