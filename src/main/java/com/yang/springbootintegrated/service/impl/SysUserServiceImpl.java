/**
 * 
 */
package com.yang.springbootintegrated.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.springbootintegrated.mapper.SysUserMapper;
import com.yang.springbootintegrated.pojo.SysUser;
import com.yang.springbootintegrated.service.SysUserService;

/**
 * @Description:SysUserServiceImpl
 * @author:yanglin
 * @time:2018年8月7日 下午9:12:12
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public void insert(SysUser sysUser) {
		sysUserMapper.insert(sysUser);
	}

}
