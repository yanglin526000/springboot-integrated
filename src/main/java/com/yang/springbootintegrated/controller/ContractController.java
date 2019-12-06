package com.yang.springbootintegrated.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yang.springbootintegrated.controller.common.BaseHIbernateController;
import com.yang.springbootintegrated.pojo.Contract;

import io.swagger.annotations.Api;

/**
 * <p>
 * 描述: 通讯录
 * </p>
 * <p>
 * 创建时间: 2019-12-04 18:01
 * </p>
 * 
 * @author yanglin
 */
@Api(tags = "contract[通讯录API]")
@CrossOrigin(origins = { "http://localhost:3000", "null" })
@RestController
@RequestMapping("contract")
public class ContractController extends BaseHIbernateController<Contract> {
}
