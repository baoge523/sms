package com.manage.sys.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 支持跨域请求
 */
@Configuration
public class CrossConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 允许的 请求的方式   --必填
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        corsConfiguration.addAllowedMethod(HttpMethod.POST);
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);

        // 运行访问 访问该服务器的 外域 uri   允许所有访问: *   -- 必填
        corsConfiguration.addAllowedOrigin("*");

        // 请求结果能够被缓存多久
        corsConfiguration.setMaxAge(3600l);

        // 注册配置
        source.registerCorsConfiguration("/**",corsConfiguration);  // 所有请求都判断是否是跨域请求

        return source;
    }


    @Bean
    public CorsFilter corsFilter(CorsConfigurationSource corsConfigurationSource){

        CorsFilter corsFilter = new CorsFilter(corsConfigurationSource);

        return corsFilter;
    }
}
