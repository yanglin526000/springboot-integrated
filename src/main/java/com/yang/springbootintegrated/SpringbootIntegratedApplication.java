package com.yang.springbootintegrated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yang.springbootintegrated.mapper")
public class SpringbootIntegratedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootIntegratedApplication.class, args);
	}
}
