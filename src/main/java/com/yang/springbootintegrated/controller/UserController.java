/**
 * 
 */
package com.yang.springbootintegrated.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping("/hello")
	public Map<String, Object> hello() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("name", "杨林热部署hahah" + yang);
		result.put("age", 23);
		return result;
	}

}
