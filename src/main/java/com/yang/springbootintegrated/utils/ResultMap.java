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
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> state(Object result, int httpState) throws Exception {
		Map<String, Object> resultHandle = null;
		if (result == null) {
			resultHandle = new HashMap<String, Object>();
			resultHandle.put("data", null);
		} else {
			if (result instanceof Map) {
				resultHandle = (Map<String, Object>) result;
			} else {
				resultHandle = new HashMap<String, Object>();
				resultHandle.put("data", result);
			}
		}

		HttpStatus hs = HttpStatus.resolve(httpState);
		if (hs == null) {
			throw new IllegalArgumentException("No matching constant for [" + httpState + "]");
		}
		resultHandle.put("code", hs.value());
		resultHandle.put("message", hs.getReasonPhrase());
		return resultHandle;
	}
}
