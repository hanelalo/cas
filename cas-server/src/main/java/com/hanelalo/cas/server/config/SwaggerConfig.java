package com.hanelalo.cas.server.config;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
  @Autowired
  private AuthServerProperties properties;

  @Bean
  public Docket createRestApi() {
    ParameterBuilder builder = new ParameterBuilder();
    List<Parameter> paras = Lists.newArrayList();
    Parameter authorization = builder.name("Authorization").description("客户端验证码")
        .modelRef(new ModelRef("string"))
        .parameterType("header").required(true).build();
    paras.add(authorization);
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        // 是否开启
        .enable(properties.isSwaggerEnable()).select()
        // 扫描的路径包
        .apis(RequestHandlerSelectors.basePackage("com.hanelalo.cas.server.endpoint"))
        // 指定路径处理PathSelectors.any()代表所有的路径
        .paths(PathSelectors.any())
        .build()
        .globalOperationParameters(paras)
        .pathMapping("/");
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("单点登录服务器（CAS SSO）")
        .description("hanelalo | CAS SERVER")
        // 作者信息
        .contact(new Contact("hanelalo", "https://github.com/hanelalo",
            "killerkingye@163.com"))
        .version("0.0.1-SNAPSHOT")
        .build();
  }

}
