package com.lrm.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置视图解析器
@Configuration
public class CrowdWebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 前端请求的url地址
        String urlPath = "inter";

        // 实际后端跳转页面（会自动拼上前后缀）
        String viewName = "testinput";

        // 前往用户注册页面
        registry.addViewController(urlPath).setViewName(viewName);

    }
}
