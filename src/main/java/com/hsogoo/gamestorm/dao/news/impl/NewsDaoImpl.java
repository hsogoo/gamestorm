package com.hsogoo.gamestorm.dao.news.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.news.NewsDao;
import com.hsogoo.gamestorm.vo.News;

/**
 * @author hsogoo
 * @time 2015-9-29 下午09:46:40
 * @description
 */
@Repository
public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public List<News> getPageNewsList(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer start = (page - 1) * pageSize;
		Integer offset = pageSize;
		map.put("start", start);
		map.put("offset", offset);
		return this.getSqlMapClientTemplate().queryForList("gs_news.getPageNewsList", map);
	}

	@Override
	public Long getTotalNewsCount() {
		Long count = (Long)this.getSqlMapClientTemplate().queryForObject("gs_news.getTotalNewsCount");
		if(count == null){
			return 0L;
		}else{
			return count;
		}
	}

	@Override
	public void doAddNews(News news) {
		this.getSqlMapClientTemplate().insert("gs_news.doAddNews", news);
	}

}
