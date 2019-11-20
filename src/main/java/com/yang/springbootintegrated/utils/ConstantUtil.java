package com.yang.springbootintegrated.utils;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 描述: ConstantUtil
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:20
 * </p>
 * 
 * @author yanglin
 */
@Component
public final class ConstantUtil {

    /**
     * @description HashMap初始化负载因子(8 [0x8])
     * @field RESULT_MAP_INIT_COUNT
     */
    public static final int RESULT_MAP_INIT_COUNT = 0x8;

    /**
     * @description 默认传出最大分页条数
     * @field DEFAULT_PAGE_SIZE
     */
    public static final String DEFAULT_PAGE_SIZE = "10000";

    /**
     * @description 默认传出页码
     * @field DEFAULT_PAGE_INDEX
     */
    public static final String DEFAULT_PAGE_INDEX = "0";

    /**
     * @description 删除标志
     * @field IS_DELETE
     */
    public static final Byte IS_DELETE = 1;

    /**
     * @description 未删除标志
     * @field IS_NOT_DELETE
     */
    public static final Byte IS_NOT_DELETE = 0;
}
