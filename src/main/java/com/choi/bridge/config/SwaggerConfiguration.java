package com.choi.bridge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*
    [CY003] 설정 후 메이븐 업데이트 진행
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /*
     * application.properties 에
     * spring.mvc.pathmatch.matching-strategy=ant_path_matcher 명시
     * path관련 에러로 인함
     */

    @Bean
    public Docket api(){
        return new Docket( DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.springboot.jpa"))
                .paths( PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title( "Spring Boot API Test with Swagger")
                .description( "설명 부분")
                .version( "1.0.0")
                .build();
    }

}
