package com.yang.springbootintegrated.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * @description 自定义返回结果结构体
 * @classname ResultMap
 *
 * @author yanglin
 * @time 2019-03-19 17:48:43.638 +0800
 * @version v1.0
 */
public final class ResultMap {

	private ResultMap() {
		super();
	}

	/**
	 * <p>
	 * 根据状态值封装Map结果信息<br>
	 * </p>
	 * 
	 * @param result    需要封装状态码的信息
	 * @param httpState 指定状态码
	 * @return resultHandle
	 * 
	 * @author:yanglin
	 * @time:2019年1月9日 上午10:39:04
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> state(Object result, int httpState) {
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
		resultHandle.put("code", hs.value());
		resultHandle.put("message", hs.getReasonPhrase());
		return resultHandle;
	}

	/**
	 * <p>
	 * 覆盖返回信息<br>
	 * </p>
	 * 
	 * @param result    需要封装状态码的信息
	 * @param httpState 指定状态码
	 * @param message   自定义状态码提示信息
	 * @return r
	 * 
	 * @author:yanglin
	 * @time:2019年1月9日 上午10:41:57
	 */
	public static Map<String, Object> state(Object result, int httpState, String message) {
		Map<String, Object> r = state(result, httpState);
		r.put("message", message);
		return r;
	}

}
