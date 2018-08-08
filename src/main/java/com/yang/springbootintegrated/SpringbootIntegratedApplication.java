package com.yang.springbootintegrated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableScheduling
//@EnableAsync
public class SpringbootIntegratedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootIntegratedApplication.class, args);
	}
}
