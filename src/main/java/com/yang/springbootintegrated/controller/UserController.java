/**
 * 
 */
package com.yang.springbootintegrated.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootintegrated.mapper.SysUserMapper;
import com.yang.springbootintegrated.pojo.SysUser;

/**
 * @Description:UserController
 * @author:yanglin
 * @time:2018年8月5日 下午10:20:55
 */
@RestController
@RequestMapping("/user")
public class UserController {
//	@Value("${yang.test}")
	@Value("${spring.datasource.url}")
	private String yang;

	@Autowired
	private SysUserMapper sysUserMapper;

	@RequestMapping("/hello")
	public Map<String, Object> hello() {
		Map<String, Object> result = new HashMap<String, Object>();
		SysUser sysUser = new SysUser();
		sysUser.setSysUserId(String.valueOf(System.currentTimeMillis()));
		sysUser.setSysUserName("yanglin");
		sysUser.setSysUserAge(23);
		sysUserMapper.insert(sysUser);
		result.put("sysUser", sysUser);
		result.put("name", "杨林热部署hahah" + yang);
		result.put("age", 23);
		return result;
	}

}
