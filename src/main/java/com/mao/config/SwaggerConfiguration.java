package com.mao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 豪
 * @date 2018/8/19 14:22
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        System.out.println("======  SWAGGER CONFIG  ======");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mao.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger开发规范")//标题
                .description("Saggger开发描述")
                .termsOfServiceUrl("http://baidu.com")//（不可见）条款地址
                .version("1.0.0")//版本号
                .build();

    }

}
