package com.hsogoo.gamestorm.dao.content;

import java.util.List;
import java.util.Map;

import com.hsogoo.gamestorm.vo.Content;
import com.hsogoo.gamestorm.vo.ContentType;

/**
 * @author hsogoo
 * @time 2015-10-7 上午11:21:09
 * @description
 */
public interface ContentDao {

	public Long getPageContentCount(Map<String, Object> condition);

	public List<Content> getPageContentList(Map<String, Object> condition);

	public void updateContentType(ContentType contentType);

	public void addContentType(ContentType contentType);

	public List<ContentType> getAllContentTypeList();

	public List<ContentType> getAllActiveContentTypeList();

	public ContentType getContentTypeById(Long id);

	public void updateContentStatus(Long typeId, Boolean status);

	public void doAddContent(Content content);

}
