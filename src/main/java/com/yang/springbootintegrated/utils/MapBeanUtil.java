package com.yang.springbootintegrated.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.yang.springbootintegrated.pojo.SysUser;

/**
 * Object和Map相互转换
 * 
 * @Description:MapBeanUtil
 * @author:yanglin
 * @time:2018年8月8日 下午5:07:02
 */
@SuppressWarnings("rawtypes")
public class MapBeanUtil {

	/**
	 * javaBean 转 Map
	 * 
	 * @param object 需要转换的javabean
	 * @return 转换结果map
	 * @throws Exception
	 */
	public static Map<String, Object> beanToMap(Object object) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		Class cls = object.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(object));
		}
		return map;
	}

	/**
	 *
	 * @param map 需要转换的map
	 * @param cls 目标javaBean的类对象
	 * @return 目标类object
	 * @throws Exception
	 */
	public static Object mapToBean(Map<String, Object> map, Class cls) throws Exception {
		Object object = cls.newInstance();
		for (String key : map.keySet()) {
			Field temFiels = cls.getDeclaredField(key);
			temFiels.setAccessible(true);
			temFiels.set(object, map.get(key));
		}
		return object;
	}

	public static void main(String[] args) throws Exception {
		SysUser sUser = new SysUser();
		sUser.setSysUserId(SnowflakeIdWorker.nextIdString());
		sUser.setSysUserName("yang");
		sUser.setSysUserAge(23);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sysUserId", "666");
		map.put("sysUserName", "yanglin666");
		map.put("sysUserAge", 666);
		// map to object
		SysUser sUserC = (SysUser) mapToBean(map, SysUser.class);
		// object to map
		Map<String, Object> mapC = beanToMap(sUser);
		System.out.println(sUserC);
		System.out.println(mapC);
	}

}
