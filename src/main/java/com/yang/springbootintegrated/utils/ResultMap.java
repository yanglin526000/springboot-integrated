package com.yang.springbootintegrated.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * 自定义结构体
 * 
 * @Description:ResultMap
 * @author:yanglin
 * @time:2018年8月8日 下午1:54:01
 */
public class ResultMap {

	/**
	 * 根据状态值封装Map结果信息
	 * 
	 * @param reslut
	 * @param state
	 * @return
	 */
	public static Map<String, Object> state(Map<String, Object> result, int httpState) {
		if (result == null) {
			result = new HashMap<String, Object>();
		}
		HttpStatus hs = HttpStatus.resolve(httpState);
		if (hs == null) {
			throw new IllegalArgumentException("No matching constant for [" + httpState + "]");
		}
		result.put("code", hs.value());
		result.put("message", hs.getReasonPhrase());
		return result;
	}
}
