package com.hsogoo.gamestorm.dao.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.vo.Content;
import com.hsogoo.gamestorm.vo.ContentType;

/**
 * @author hsogoo
 * @time 2015-10-7 上午11:21:23
 * @description
 */
@Repository
public class ContentDaoImpl extends BaseDao implements ContentDao{

	@Override
	public Long getPageContentCount(Map<String, Object> condition) {
		Long contentCount = (Long)this.getSqlMapClientTemplate().queryForObject("gs_content.getPageContentCount",condition);
		if(contentCount == null){
			return 0L;
		}
		return contentCount;
	}

	@Override
	public List<Content> getPageContentList(Map<String, Object> condition) {
		return this.getSqlMapClientTemplate().queryForList("gs_content.getPageContentList", condition);
	}

	@Override
	public void updateContentType(ContentType contentType) {
		this.getSqlMapClientTemplate().update("gs_content_type.updateContentType", contentType);
	}

	@Override
	public void addContentType(ContentType contentType) {
		this.getSqlMapClientTemplate().update("gs_content_type.addContentType", contentType);
	}

	@Override
	public List<ContentType> getAllContentTypeList() {
		return this.getSqlMapClientTemplate().queryForList("gs_content_type.getAllContentTypeList");
	}

	@Override
	public List<ContentType> getAllActiveContentTypeList() {
		return this.getSqlMapClientTemplate().queryForList("gs_content_type.getAllActiveContentTypeList");
	}

	@Override
	public ContentType getContentTypeById(Long id) {
		return (ContentType)this.getSqlMapClientTemplate().queryForObject("gs_content_type.getContentTypeById", id);
	}

	@Override
	public void updateContentStatus(Long typeId, Boolean status) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("typeId", typeId);
		condition.put("status", status);
		this.getSqlMapClientTemplate().update("gs_content.updateContentStatus", condition);
	}

	@Override
	public void doAddContent(Content content) {
		this.getSqlMapClientTemplate().insert("gs_content.doAddContent", content);
	}

}
