package com.yang.springbootintegrated.utils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * <p>
 * 描述: 参数处理工具类
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:20
 * </p>
 * 
 * @author yanglin
 */
public class ParamUtil {

    /**
     * <p>
     * 描述:
     * </p>
     * <p>
     * 创建时间: 2019-11-15 09:20
     * </p>
     * 
     * @param o          任意对象
     * @param fieldName  属性名
     * @param fieldValue 属性值
     * 
     * @author yanglin
     */
    public static void putField(Object o, String fieldName, Object fieldValue) {
        // 属性值为空，不设置值
        if (fieldValue == null) {
            return;
        }
        try {
            Field f = null;
            try {
                f = o.getClass().getDeclaredField(fieldName);
            } catch (Exception e) {
                f = o.getClass().getSuperclass().getDeclaredField(fieldName);
            }
            f.setAccessible(true);
            // 属性值为空字符串时候，将对应字段值为空，否则正常设置属性值
            if ("".equals(fieldValue.toString().trim())) {
                f.set(o, null);
            } else {
                Object fv = null;
                // 日期类型和其他常用类型的处理
                if (Date.class.getName().equals(f.getType().getName())) {
                    if (fieldValue instanceof Date) {
                        fv = fieldValue;
                    } else {
                        fv = f.getType().getDeclaredConstructor(long.class)
                                .newInstance(Long.parseLong(fieldValue.toString().trim()));
                    }
                } else {
                    fv = f.getType().getDeclaredConstructor(String.class).newInstance(fieldValue.toString().trim());
                }
                f.set(o, fv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
