package com.change.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        /*
        //设置要显示的环境
        Profiles profiles=Profiles.of("dev","test");
        //判断是否处在设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);
        */
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("change")
//                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.change.controller"))
                //过滤
                //.paths(PathSelectors.ant("/change/**"))
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置swagger信息apiInfo
    public ApiInfo apiInfo(){
        Contact contact=new Contact("change","","759786327@qq.com");
        return new ApiInfo(
                "规划院碳中和大创项目后端接口配置",
                "规划院碳中和大创项目后端接口配置",
                "1.0.0-snap",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
