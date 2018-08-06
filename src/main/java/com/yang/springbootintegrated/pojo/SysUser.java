package com.yang.springbootintegrated.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
	/**
	 * 系统用户ID
	 */
	@Id
	@Column(name = "sys_user_id")
	private String sysUserId;

	/**
	 * 系统用户名字
	 */
	@Column(name = "sys_user_name")
	private String sysUserName;

	/**
	 * 系统用户年龄
	 */
	@Column(name = "sys_user_age")
	private Integer sysUserAge;

	private static final long serialVersionUID = 1L;

	/**
	 * 获取系统用户ID
	 *
	 * @return sys_user_id - 系统用户ID
	 */
	public String getSysUserId() {
		return sysUserId;
	}

	/**
	 * 设置系统用户ID
	 *
	 * @param sysUserId 系统用户ID
	 */
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	/**
	 * 获取系统用户名字
	 *
	 * @return sys_user_name - 系统用户名字
	 */
	public String getSysUserName() {
		return sysUserName;
	}

	/**
	 * 设置系统用户名字
	 *
	 * @param sysUserName 系统用户名字
	 */
	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	/**
	 * 获取系统用户年龄
	 *
	 * @return sys_user_age - 系统用户年龄
	 */
	public Integer getSysUserAge() {
		return sysUserAge;
	}

	/**
	 * 设置系统用户年龄
	 *
	 * @param sysUserAge 系统用户年龄
	 */
	public void setSysUserAge(Integer sysUserAge) {
		this.sysUserAge = sysUserAge;
	}
}