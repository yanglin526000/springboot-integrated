/**
 * 
 */
package com.yang.springbootintegrated.service;

import com.yang.springbootintegrated.pojo.SysUser;

/**
 * @Description:SysUserService
 * @author:yanglin
 * @time:2018年8月7日 下午8:46:35
 */
public interface SysUserService {

	/**
	 * 插入用户信息
	 * 
	 * @param sysUser
	 */
	void insert(SysUser sysUser);

}
