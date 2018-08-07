/**
 * 
 */
package com.yang.springbootintegrated.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootintegrated.pojo.SysUser;
import com.yang.springbootintegrated.service.SysUserService;
import com.yang.springbootintegrated.utils.SnowflakeIdWorker;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @Description:UserController
 * @author:yanglin
 * @time:2018年8月5日 下午10:20:55
 */
@Api(value = "用户模块相关API", tags = "SysUserApi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 新增用户信息
	 * 
	 * @param name
	 * @param age
	 * @return
	 */
	@ApiOperation(value = "新增用户信息", notes = "根据url的name和age来新增用户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "age", value = "用户年龄", required = true, dataType = "Integer", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 0, message = "") })
	@RequestMapping(value = "/addsysuser", method = RequestMethod.POST)
	public Map<String, Object> addSysUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "age") Integer age) {
		Map<String, Object> result = new HashMap<String, Object>();
		SysUser sysUser = new SysUser();
		sysUser.setSysUserId(SnowflakeIdWorker.nextIdString());
		sysUser.setSysUserName(name);
		sysUser.setSysUserAge(age);
		sysUserService.insert(sysUser);
		result.put("sysUser", sysUser);
		result.put("name", "杨林热部署");
		result.put("age", 23);
		return result;
	}

}
