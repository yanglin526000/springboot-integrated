package com.yang.springbootintegrated.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.yang.springbootintegrated.pojo.SysUser;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface SysUserMapper extends Mapper<SysUser> {

	/**
	 * 自定义查询
	 * 
	 * @param cond
	 * @return
	 */
	@Select("select * from sys_user su where su.sys_user_name = #{sys_user_name}")
	List<Map<String, Object>> selectCustom(Map<String, Object> cond);
}