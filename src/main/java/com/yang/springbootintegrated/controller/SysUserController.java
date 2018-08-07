/**
 * 
 */
package com.yang.springbootintegrated.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootintegrated.pojo.SysUser;
import com.yang.springbootintegrated.service.SysUserService;
import com.yang.springbootintegrated.utils.SnowflakeIdWorker;

/**
 * @Description:UserController
 * @author:yanglin
 * @time:2018年8月5日 下午10:20:55
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public Map<String, Object> hello() {
		Map<String, Object> result = new HashMap<String, Object>();
		SysUser sysUser = new SysUser();
		sysUser.setSysUserId(SnowflakeIdWorker.nextIdString());
		sysUser.setSysUserName("yanglin");
		sysUser.setSysUserAge(23);
		sysUserService.insert(sysUser);
		result.put("sysUser", sysUser);
		result.put("name", "杨林热部署hahah");
		result.put("age", 23);
		return result;
	}

}
