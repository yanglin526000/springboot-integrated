/**
 * 
 */
package com.yang.springbootintegrated.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootintegrated.pojo.SysUser;
import com.yang.springbootintegrated.service.SysUserService;
import com.yang.springbootintegrated.task.async.TestAsyncTask;
import com.yang.springbootintegrated.utils.HttpStateUtil;
import com.yang.springbootintegrated.utils.ResultMap;
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

	@Autowired
	private TestAsyncTask testAsyncTask;

	/**
	 * 新增用户信息
	 * 
	 * @param name
	 * @param age
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "新增用户信息", notes = "根据url的name和age来新增用户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "Long", paramType = "query"),
			@ApiImplicitParam(name = "age", value = "用户年龄", required = true, dataType = "Integer", paramType = "query") })
	@ApiResponses(value = { @ApiResponse(code = 0, message = "") })
	@RequestMapping(value = "/addsysuser", method = RequestMethod.POST)
	public Map<String, Object> addSysUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "age") Integer age) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		SysUser sysUser = new SysUser();
		sysUser.setSysUserId(SnowflakeIdWorker.nextIdString());
		sysUser.setSysUserName(name);
		sysUser.setSysUserAge(age);
		sysUserService.insert(sysUser);
		result.put("sysUser", sysUser);
		result.put("name", "杨林热部署");
		result.put("age", 23);
		return ResultMap.state(result, HttpStateUtil.OK);
	}

	/**
	 * 异步任务测试
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "异步任务测试", notes = "异步任务测试", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({})
	@ApiResponses(value = { @ApiResponse(code = 0, message = "") })
	@RequestMapping(value = "/async", method = RequestMethod.POST)
	public Map<String, Object> testAsyncTask() throws InterruptedException {
		Map<String, Object> result = new HashMap<String, Object>();
		long begin = System.currentTimeMillis();

		Future<String> task4 = testAsyncTask.task4();
		Future<String> task5 = testAsyncTask.task5();
		Future<String> task6 = testAsyncTask.task6();

		// 如果都执行往就可以跳出循环,isDone方法如果此任务完成，true
		for (;;) {
			if (task4.isDone() && task5.isDone() && task6.isDone()) {
				break;
			}
		}

		long end = System.currentTimeMillis();
		long total = end - begin;
		System.out.println("执行总耗时=" + total);
		result.put("total", total);
		return result;
	}

	/**
	 * url异常测试
	 * 
	 * @return
	 */
	@ApiOperation(value = "url异常测试", notes = "url异常测试", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({})
	@ApiResponses(value = { @ApiResponse(code = 0, message = "") })
	@RequestMapping(value = "/errorurl", method = RequestMethod.POST)
	public Map<String, Object> errorUrl() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("error", 1 / 0);

		return result;
	}

}
