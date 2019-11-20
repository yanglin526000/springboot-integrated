package com.yang.springbootintegrated.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yang.springbootintegrated.utils.ConstantUtil;
import com.yang.springbootintegrated.utils.ResultMap;

/**
 * @description 处理异常全局配置：拦截异常并统一处理
 * @classname GlobalThrowableHandler
 *
 * @author yanglin
 * @time 2019-03-19 17:47:24.110 +0800
 * @version v1.0
 */
@RestControllerAdvice
public class GlobalThrowableHandler {

    /**
     * @description 异常具体处理过程
     * @param t       异常对象
     * @param request 请求域对象
     * @return java.util.Map<String, Object>
     * 
     * @author yanglin
     * @time 2019-03-19 17:50:51.879 +0800
     */
    @ExceptionHandler(value = Throwable.class)
    private Map<String, Object> handleThrowable(Throwable t, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>(ConstantUtil.RESULT_MAP_INIT_COUNT);
        t.printStackTrace();
        result.put("errorMessage", t.getMessage());
        result.put("errorURL", request.getRequestURL());
        ResultMap.state(result, HttpStatus.INTERNAL_SERVER_ERROR);
        return result;
    }
}
