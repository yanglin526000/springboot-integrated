package com.yang.springbootintegrated.utils;

import org.springframework.stereotype.Component;

/**
 * @description 常量工具类
 * @classname ConstantUtil
 *
 * @author yanglin
 * @time 2019-03-19 17:46:02.911 +0800
 * @version v1.0
 */
@Component
public final class ConstantUtil {
	/**
	 * <p>
	 * 系统异常属性名<br>
	 * </p>
	 *
	 * @Fields:SYSTEM_EXCEPTION
	 * @author:yanglin
	 * @time:2019年1月24日 下午1:47:44
	 */
	public static final String SYSTEM_EXCEPTION = "SystemException";

	/**
	 * <p>
	 * HashMap初始化负载因子(8 [0x8])<br>
	 * </p>
	 *
	 * @Fields:RESULT_MAP_INIT_COUNT
	 * @author:yanglin
	 * @time:2019年1月24日 下午1:48:27
	 */
	public static final int RESULT_MAP_INIT_COUNT = 0x8;

	/**
	 * <p>
	 * 默认传出最大分页条数<br>
	 * </p>
	 *
	 * @Fields:DEFAULT_PAGE_SIZE
	 * @author:TianTang
	 * @time:2019年1月24日 下午2:02:32
	 */
	public static final String DEFAULT_PAGE_SIZE = "10000";

	/**
	 * <p>
	 * 默认传出页码<br>
	 * </p>
	 *
	 * @Fields:DEFAULT_PAGE_SIZE
	 * @author:TianTang
	 * @time:2019年1月24日 下午2:02:32
	 */
	public static final String DEFAULT_PAGE_INDEX = "0";

}
