package com.hsogoo.gamestorm.controller.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.content.ContentService;
import com.hsogoo.gamestorm.vo.Content;
import com.hsogoo.gamestorm.vo.ContentType;
import com.hsogoo.gamestorm.vo.News;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:17:13
 * @description
 */
@Controller
@RequestMapping("/backend/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/manage")
	public ModelAndView getContentPage(ModelAndView model){
		List<ContentType> contentTypeList = contentService.getAllActiveContentTypeList();
		model.addObject("contentTypeList", contentTypeList);
		model.setViewName("/backend/content/contentManager");
		return model;
	}
	
	@RequestMapping("/contentList")
	@ResponseBody
	public ModelAndView getContentList(ModelAndView model,
									@RequestParam (value ="page") String page,
									@RequestParam (value ="typeName") String typeName,
									@RequestParam (value ="typeId") String typeId){
		int pageSize = 10;
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(page);
		}catch (Exception e) {
			currentPage = 1;
		}
		List<Content> contentList = contentService.getPageContentList(currentPage, pageSize, typeId);
		Long totalCount = contentService.getPageContentCount(typeId);
		model.setViewName("/backend/content/contentList");
		model.addObject("currentPage", page);
		model.addObject("totalPage", (totalCount -1) / pageSize + 1 );
		model.addObject("contentList", contentList);
		model.addObject("typeId", typeId);
		model.addObject("typeName", typeName);
		return model;
	}

	@RequestMapping("/contentTypeSetting")
	public ModelAndView getContentTypePage(ModelAndView model){
		List<ContentType> contentTypeList = contentService.getAllContentTypeList();
		model.setViewName("/backend/content/contentTypeSetting");
		model.addObject("contentTypeList", contentTypeList);
		return model;
	}
	
	@RequestMapping("/addContentType")
	public ModelAndView doAddContentType(ContentType contentType){
		contentService.addContentType(contentType);
		ModelAndView model = new ModelAndView("redirect:/backend/content/contentTypeSetting");
		return model;
	}

    @RequestMapping("/updateContentType")
    public ModelAndView doSaveContentType(ContentType contentType){
    	contentService.updateContentType(contentType);
        ModelAndView model = new ModelAndView("redirect:/backend/content/contentTypeSetting");
        return model;
    }
    
    @RequestMapping("/addNewContent")
    public ModelAndView addNewContentPage(ModelAndView model){
		List<ContentType> contentTypeList = contentService.getAllActiveContentTypeList();
		model.addObject("contentTypeList", contentTypeList);
		model.setViewName("/backend/content/contentAddPage");
        return model;
    }
    
    @RequestMapping("/doAddContent")
    public ModelAndView doAddContent(Content content){
    	contentService.doAddContent(content);
        ModelAndView model = new ModelAndView("redirect:/backend/content/manage");
        return model;
    }
    

}