package com.yang.springbootintegrated.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置信息
 * 
 * @Description:Swagger2
 * @author:yanglin
 * @time:2018年8月7日 下午10:57:44
 */
@Configuration
public class Swagger2 {
	
	// 自定义异常信息
	private static final List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new ResponseMessageBuilder().code(200).message("成功").build());
			add(new ResponseMessageBuilder().code(400).message("请求参数错误").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(401).message("权限认证失败").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(403).message("请求资源不可用").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(404).message("请求资源不存在").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(409).message("请求资源冲突").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(415).message("请求格式错误").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(423).message("请求资源被锁定").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(501).message("请求方法不存在").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(503).message("服务暂时不可用").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(-1).message("未知异常").responseModel(new ModelRef("Error")).build());
		}
	};

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 扫描的API包
				.apis(RequestHandlerSelectors.basePackage("com.yang.springbootintegrated.controller"))
				.paths(PathSelectors.any()).build().globalResponseMessage(RequestMethod.GET, responseMessages)
				.globalResponseMessage(RequestMethod.POST, responseMessages)
				.globalResponseMessage(RequestMethod.PUT, responseMessages)
				.globalResponseMessage(RequestMethod.DELETE, responseMessages);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Springboot利用Swagger2构建API文档").description("用于生成文档以及测试接口")
				.termsOfServiceUrl("http://localhost:8080").version("1.0").build();
	}
}