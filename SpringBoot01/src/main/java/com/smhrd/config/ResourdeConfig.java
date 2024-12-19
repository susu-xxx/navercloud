package com.smhrd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Class 파일에서 설정을 하는 경우도 있음
//외부 리소스 접근 url을 만드는 설정, security 등...

@Configuration
public class ResourdeConfig implements WebMvcConfigurer { 
	
	@Value("${save.path}")
	private String savePath;
	
	//외부 리소스(폴더)에 접근하는 url을 지정하는 것
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
		//http://localhost:8088/save/**
		
		// C:/save/cat.jpg
		registry.addResourceHandler("/save/**") // 어떤 양식의 url인지  *(전체)*(확장자)
				.addResourceLocations( "file:///" + savePath)	//어떤 폴더랑 연결할 건지
		;
	}
	
	
	

}
