package com.hsogoo.gamestorm.service.content;

import java.util.List;

import com.hsogoo.gamestorm.vo.Content;
import com.hsogoo.gamestorm.vo.ContentType;

/**
 * @author hsogoo
 * @time 2015-10-7 上午11:19:55
 * @description
 */
public interface ContentService {

	public List<ContentType> getAllContentTypeList();
	
	public List<ContentType> getAllActiveContentTypeList();

	public void addContentType(ContentType contentType);

	public void updateContentType(ContentType userLevel);

	public List<Content> getPageContentList(int currentPage, int pageSize, String contentType);

	public Long getPageContentCount(String contentType);

	public void doAddContent(Content content);

}
