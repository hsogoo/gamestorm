package com.hsogoo.gamestorm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.hsogoo.gamestorm.util.GenerateCodeUtil;

/**
 * @author hsogoo
 * @time 2015-9-17 下午10:49:16	
 * @description
 */
@Controller
@RequestMapping("/file")
public class UploadController {

	private static final String FILE_PATH = "/static/upload/";

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String rootPath = request.getRealPath("/");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		MultipartFile multipartFile = multipartRequest
				.getFile(fileNames.next());
		// 获得文件原始名称
		String name = multipartFile.getOriginalFilename();
		String newFileName = generateFileName(name);
		String filePath = rootPath + FILE_PATH + newFileName;
		saveFile(filePath, multipartFile.getBytes());
		Map<String, String> resultMap = new HashMap<String, String>(5);
		resultMap.put("result", "success");
		resultMap.put("filePath", FILE_PATH + newFileName);
		return JSON.toJSONString(resultMap);
	}

	// 保存文件的方法
	private void saveFile(String filePath, byte[] content) throws IOException {
		BufferedOutputStream bos = null;
		try {
			File file = new File(filePath);
			// 判断文件路径是否存在
			if (!file.getParentFile().exists()) {
				// 文件路径不存在时，创建保存文件所需要的路径
				file.getParentFile().mkdirs();
			}
			// 创建文件（这是个空文件，用来写入上传过来的文件的内容）
			file.createNewFile();
			bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(content);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("文件不存在。");
		} finally {
			if (null != bos) {
				bos.close();
			}
		}
	}
	
	private String generateFileName(String fileName){
		String fileSuffix = "。jpg";
		if ((fileName != null) && (fileName.length() > 0)) {   
            int dot = fileName.lastIndexOf('.');   
            if ((dot >-1) && (dot < (fileName.length() - 1))) {   
            	fileSuffix = fileName.substring(dot);   
            }   
        }
		long currentTime = System.currentTimeMillis();
		return GenerateCodeUtil.generateShortUuid() + String.valueOf(currentTime) + fileSuffix;
	}

}
