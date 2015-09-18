package com.hsogoo.gamestorm.vo;
/**
 * @author hsogoo
 * @time 2015-9-13 下午02:10:27
 * @description
 */
public class User {
	
	private Long id;
	private String userName;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
