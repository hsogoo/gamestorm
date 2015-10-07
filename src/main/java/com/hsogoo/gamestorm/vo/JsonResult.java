package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author hsogoo
 * @time 2015-10-7 下午07:40:05
 * @description
 */
public class JsonResult<T> implements Serializable {

	private static final long serialVersionUID = -800064873352023124L;
	
	private String code;
	private String message;
	private T data;
	private List<T> dataList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
