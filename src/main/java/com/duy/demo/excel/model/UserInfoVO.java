package com.duy.demo.excel.model;

import lombok.Data;

import java.util.Date;
/**
 * 读取Excel用户信息
 * @author CW6169 
 * @date 2019年1月9日
 */
@Data
public class UserInfoVO {
	/*工号	姓名	性别	年龄	电话	民族	婚姻状况	学历	选择岗位	入职时间	工作地点  岗位*/
	/**
	 * 工号
	 */
	private String loginName;
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 民族字典id
	 */
	private String nationId;
	/**
	 * 婚姻状况
	 */
	private String marriage;
	/**
	 * 婚姻字典id
	 */
	private String marriageId;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 学历字典id
	 */
	private String educationId;
	/**
	 * 入职时间
	 */
	private Date employmentDate;
	/**
	 * 工作地点
	 */
	private String workAddr;
	
	/**
	 * 工作地点对应字典表
	 */
	private String workAddrId;
	/**
	 * 岗位
	 */
	private String positionTitle;
	/**
	 * 岗位字典字段
	 */
	private String position;
	
	
	private String passFlag;


	/**
	 * 该纪录在Excel表中的哪一行
	 */
	private int index;

	
	
	
}
