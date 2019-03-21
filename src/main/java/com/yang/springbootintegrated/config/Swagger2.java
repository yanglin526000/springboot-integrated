package com.yang.springbootintegrated.config;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description Swagger2配置文件
 * @classname Swagger2
 *
 * @author yanglin
 * @time 2019-03-21 16:55:07.190 +0800
 * @version v1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	/**
	 * @description 创建访问路径
	 * @return Docket
	 * 
	 * @author yanglin
	 * @time 2019-03-21 16:55:21.290 +0800
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.wonders.pathcloudserver.controller"))
				.paths(PathSelectors.regex("^(?!auth).*$")).build().securitySchemes(securitySchemes())
				.securityContexts(securityContexts());
	}

	/**
	 * @description Swagger2主信息
	 * @return ApiInfo
	 * 
	 * @author yanglin
	 * @time 2019-03-21 16:55:49.338 +0800
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("path-cloud-server").description("springboot利用swagger构建api文档")
				.termsOfServiceUrl("").version("1.0").build();
	}

	/**
	 * @description 配置了哪些操作与SecuritySchemes相关联的配置
	 * @return List<ApiKey>
	 * 
	 * @author yanglin
	 * @time 2019-03-21 16:55:58.426 +0800
	 */
	private List<ApiKey> securitySchemes() {
		return newArrayList(new ApiKey("token", "token", "header"));
	}

	/**
	 * @description 配置api操作（通过正则表达式模式）和HTTP方法将安全上下文应用于apis
	 * @return List<SecurityContext>
	 * 
	 * @author yanglin
	 * @time 2019-03-21 16:56:14.905 +0800
	 */
	private List<SecurityContext> securityContexts() {
		return newArrayList(SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("^(?!auth).*$")).build());
	}

	/**
	 * @description 默认的认证信息
	 * @return List<SecurityReference>
	 * 
	 * @author yanglin
	 * @time 2019-03-21 16:56:41.595 +0800
	 */
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("token", authorizationScopes));
	}
}
