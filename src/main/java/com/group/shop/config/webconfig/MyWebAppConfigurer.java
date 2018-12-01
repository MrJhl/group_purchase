package com.group.shop.config.webconfig;

import java.util.ArrayList;
import java.util.List;

import com.group.shop.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.group.shop.config.interceptor.LoginInterceptor;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer{

    /**
     * 静态资源配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置模板资源路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        //registry.addResourceHandler("/upload/**").addResourceLocations("file:/o2o/itjhl/images/upload/");
    }

    /**
     * 添加拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /** 店家管理系统拦截部分 **/
        String interceptPath = "/**";
        // 注册拦截器
        InterceptorRegistration loginIR = registry.addInterceptor(new LoginInterceptor());
        // 配置拦截的路径
        loginIR.addPathPatterns(interceptPath);

        /** 不拦截部分 **/
        loginIR.excludePathPatterns("/static/**");
        loginIR.excludePathPatterns("/page/login");
        loginIR.excludePathPatterns("/user/logout");
        loginIR.excludePathPatterns("/goodsshop/goodslist/**");
        List<String> patterns = new ArrayList<>();
        patterns.add("/user/loginSys");
        patterns.add("/user/phonelogin");
        patterns.add("/cash/**");
        patterns.add("/user/token");
        loginIR.excludePathPatterns(patterns);
    }

}

