package com.yang.springbootintegrated.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.yang.springbootintegrated.pojo.DictionaryInfo;

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
                // 传过来的值是对应实例
                if (f.getType().isInstance(fieldValue)) {
                    fv = fieldValue;
                } else if (Date.class.getName().equals(f.getType().getName())) {
                    // 日期类型和其他常用类型的处理
                    fv = f.getType().getDeclaredConstructor(long.class)
                            .newInstance(Long.parseLong(fieldValue.toString().trim()));
                } else {
                    fv = f.getType().getDeclaredConstructor(String.class).newInstance(fieldValue.toString().trim());
                }
                if (ArrayList.class.equals(fieldValue.getClass())) {
                    o.getClass()
                            .getDeclaredMethod(
                                    "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1),
                                    f.getType())
                            .invoke(o, fv);
                } else {
                    f.set(o, fv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * 描述: 生成随机属性对象
     * </p>
     * <p>
     * 创建时间: 2019-11-21 13:44
     * </p>
     * <p>
     * 更新时间: 2019-11-21 13:44
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param o 对象值
     * 
     * @author yanglin
     */
    public static void randomObject(Object o) {
        // 值为空，不做任何操作
        if (o == null) {
            return;
        }
        String r = String.valueOf(System.currentTimeMillis());
        for (Field f : o.getClass().getDeclaredFields()) {
            if (!"serialVersionUID".equals(f.getName())) {
                for (int i = 0, len = r.length(); i < len - 1; i++) {
                    try {
                        f.setAccessible(true);
                        Object fv = null;
                        try {
                            fv = f.getType().getDeclaredConstructor(String.class).newInstance(r.substring(len - i - 1));
                        } catch (Exception e) {
                            fv = f.getType().getDeclaredConstructor(long.class)
                                    .newInstance(Long.parseLong(r.substring(len - i - 1)));
                        }
                        f.set(o, fv);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * <p>
     * 描述: 处理列表的中的字典信息
     * </p>
     * <p>
     * 创建时间: 2019-11-27 15:09
     * </p>
     * <p>
     * 更新时间: 2019-11-27 15:09
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param list 列表
     * @return List<Map<String, Object>>
     * 
     * @author yanglin
     */
    @SuppressWarnings("unchecked")
    public static List<?> handleDictionaryInfo(List<?> list) {
        // 值为空，不做任何操作
        if (list == null) {
            return null;
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (Object l : list) {
            Map<String, Object> ml = (Map<String, Object>) JSONObject.toJSON(l);
            Map<String, Object> rh = new HashMap<>();
            // 移除字典对象
            Iterator<Map.Entry<String, Object>> it = ml.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                String key = entry.getKey();
                if (key.endsWith("DictionaryInfo")) {
                    rh.put(key, ml.get(key));
                    it.remove();
                }
            }
            // 增加字典名
            for (String r : rh.keySet()) {
                if (rh.get(r) != null) {
                    ml.put(r.replaceAll("DictionaryInfo", "") + "Name",
                            JSONObject.parseObject(rh.get(r).toString(), DictionaryInfo.class).getName());
                } else {
                    ml.put(r.replaceAll("DictionaryInfo", "") + "Name", null);
                }
            }
            result.add(ml);
        }
        return result;
    }

    /**
     * <p>
     * 描述: 处理对象字典
     * </p>
     * <p>
     * 创建时间: 2019-11-27 13:37
     * </p>
     * <p>
     * 更新时间: 2019-11-27 13:37
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param o 处理对象
     * @return Object
     * 
     * @author yanglin
     */
    public static Object handleDictionaryInfo(Object o) {
        // 值为空，不做任何操作
        if (o == null) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        list.add(o);
        return handleDictionaryInfo(list).get(0);
    }

}
