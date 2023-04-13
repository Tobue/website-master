package com.website.configuration;


import com.website.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * @author tsy
 * @description bean注册
 * @create 2020-08-18 16:30
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



	@Bean
	public AuthInterceptor getAuthInterceptor() {
		return new AuthInterceptor();
	}

	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(getAuthInterceptor())
				.addPathPatterns("/*");

	}

	//解决中文乱码问题
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 解决controller返回字符串中文乱码问题
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof StringHttpMessageConverter) {
				((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
			}
		}
	}


	//后缀名匹配增强
	@Override
	public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
		pathMatchConfigurer.setUseSuffixPatternMatch(false);
		pathMatchConfigurer.setUseRegisteredSuffixPatternMatch(true);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}


}