package com.bootdo.order.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author V0W&ssc
 * @email 1992lcg@163.com
 * @date 2018-11-15 16:02:46
 */
public class SubmissionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String 客户编号;
	//
	private String 员工编号;
	//
	private Date 执行日期;
	//
	private Integer 消费次数;

	/**
	 * 设置：
	 */
	public void set客户编号(String 客户编号) {
		this.客户编号 = 客户编号;
	}
	/**
	 * 获取：
	 */
	public String get客户编号() {
		return 客户编号;
	}
	/**
	 * 设置：
	 */
	public void set员工编号(String 员工编号) {
		this.员工编号 = 员工编号;
	}
	/**
	 * 获取：
	 */
	public String get员工编号() {
		return 员工编号;
	}
	/**
	 * 设置：
	 */
	public void set执行日期(Date 执行日期) {
		this.执行日期 = 执行日期;
	}
	/**
	 * 获取：
	 */
	public Date get执行日期() {
		return 执行日期;
	}
	/**
	 * 设置：
	 */
	public void set消费次数(Integer 消费次数) {
		this.消费次数 = 消费次数;
	}
	/**
	 * 获取：
	 */
	public Integer get消费次数() {
		return 消费次数;
	}
}
