package com.yang.springbootintegrated.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootintegrated.controller.common.BaseMyBatisController;
import com.yang.springbootintegrated.pojo.Biopsy;

import io.swagger.annotations.Api;

/**
 * <p>
 * 描述: 扫描切片信息
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:49
 * </p>
 * 
 * @author yanglin
 */
@Api(tags = "biopsy[扫描切片信息API]")
@RestController
@RequestMapping("biopsy")
public class BiopsyController extends BaseMyBatisController<Biopsy> {
}
