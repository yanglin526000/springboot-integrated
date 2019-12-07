package com.yang.springbootintegrated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * <p>
 * 描述: 程序启动入口类
 * </p>
 * <p>
 * 创建时间: 2019-11-20 11:11
 * </p>
 * 
 * @author yanglin
 */
@CrossOrigin(origins = "*")
@SpringBootApplication
public class SpringbootIntegratedApplication {

    /**
     * <p>
     * 描述: 运行主方法
     * </p>
     * <p>
     * 创建时间: 2019-11-20 11:12
     * </p>
     * <p>
     * 更新时间: 2019-11-20 11:12
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @param args 运行参数
     * 
     * @author yanglin
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegratedApplication.class, args);
    }
}
