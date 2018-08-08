package com.yang.springbootintegrated.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.yang.springbootintegrated.utils.HttpStateUtil;
import com.yang.springbootintegrated.utils.ResultMap;

/**
 * 全局异常处理（兼容Ajax请求和Web请求）
 * 
 * @Description:GlobalExceptionHandler
 * @author:yanglin
 * @time:2018年8月8日 上午9:02:38
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 全局异常跳转页面
	 */
	public static final String GLOBAL_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, Exception e) throws Exception {
		e.printStackTrace();
		if (isAjax(reqest)) {
			return ResultMap.state(e, HttpStateUtil.INTERNAL_SERVER_ERROR);
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", reqest.getRequestURL());
			mav.setViewName(GLOBAL_ERROR_VIEW);
			return mav;
		}
	}

	/**
	 * 判断是否是Ajax请求
	 * 
	 * @param httpRequest
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest httpRequest) {
		return (httpRequest.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
	}
}
