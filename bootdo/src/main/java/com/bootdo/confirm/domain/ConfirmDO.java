package com.bootdo.confirm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-11-22 18:07:01
 */
public class ConfirmDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户姓名
	private String username;
	//项目1
	private String project1;
	//项目1确认
	private Integer readyConfirm1;
	//项目2
	private String project2;
	//项目2确认
	private Integer readyConfirm2;

	/**
	 * 设置：用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：项目1
	 */
	public void setProject1(String project1) {
		this.project1 = project1;
	}
	/**
	 * 获取：项目1
	 */
	public String getProject1() {
		return project1;
	}
	/**
	 * 设置：项目1确认
	 */
	public void setReadyConfirm1(Integer readyConfirm1) {
		this.readyConfirm1 = readyConfirm1;
	}
	/**
	 * 获取：项目1确认
	 */
	public Integer getReadyConfirm1() {
		return readyConfirm1;
	}
	/**
	 * 设置：项目2
	 */
	public void setProject2(String project2) {
		this.project2 = project2;
	}
	/**
	 * 获取：项目2
	 */
	public String getProject2() {
		return project2;
	}
	/**
	 * 设置：项目2确认
	 */
	public void setReadyConfirm2(Integer readyConfirm2) {
		this.readyConfirm2 = readyConfirm2;
	}
	/**
	 * 获取：项目2确认
	 */
	public Integer getReadyConfirm2() {
		return readyConfirm2;
	}
}
