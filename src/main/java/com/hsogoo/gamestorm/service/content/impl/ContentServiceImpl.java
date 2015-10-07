package com.hsogoo.gamestorm.service.content.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsogoo.gamestorm.dao.content.ContentDao;
import com.hsogoo.gamestorm.service.content.ContentService;
import com.hsogoo.gamestorm.vo.Content;
import com.hsogoo.gamestorm.vo.ContentType;

/**
 * @author hsogoo
 * @time 2015-10-7 上午11:20:17
 * @description
 */
@Service
public class ContentServiceImpl implements ContentService{

	@Autowired
	private ContentDao contentDao;
	
	@Override
	public List<ContentType> getAllContentTypeList() {
		return contentDao.getAllContentTypeList();
	}

	@Override
	public List<ContentType> getAllActiveContentTypeList() {
		return contentDao.getAllActiveContentTypeList();
	}

	@Override
	public void addContentType(ContentType contentType) {
		contentDao.addContentType(contentType);
	}

	@Override
	@Transactional
	public void updateContentType(ContentType contentType) {
		ContentType oldContentType = contentDao.getContentTypeById(contentType.getId());
		if(oldContentType == null){
			return;
		}
		if(oldContentType.getStatus()!= null && !oldContentType.getStatus().equals(contentType.getStatus())){
			contentDao.updateContentStatus(contentType.getId(), contentType.getStatus());
		}
		contentDao.updateContentType(contentType);
	}

	@Override
	public List<Content> getPageContentList(int currentPage, int pageSize,
			String typeId) {
		Map<String, Object> condition = new HashMap<String, Object>();
		Integer start = (currentPage - 1) * pageSize;
		Integer offset = pageSize;
		condition.put("start", start);
		condition.put("offset", offset);
		condition.put("typeId", typeId);
		return contentDao.getPageContentList(condition);
	}

	@Override
	public Long getPageContentCount(String typeId) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("typeId", typeId);
		return contentDao.getPageContentCount(condition);
	}

	@Override
	public void doAddContent(Content content) {
		contentDao.doAddContent(content);
	}

}
