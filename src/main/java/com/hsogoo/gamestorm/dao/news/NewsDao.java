package com.hsogoo.gamestorm.dao.news;

import java.util.List;

import com.hsogoo.gamestorm.vo.News;

/**
 * @author hsogoo
 * @time 2015-9-29 下午09:45:39
 * @description
 */
public interface NewsDao {

	public List<News> getPageNewsList(int currentPage, int pageSize);

	public Long getTotalNewsCount();

	public void doAddNews(News news);

}
