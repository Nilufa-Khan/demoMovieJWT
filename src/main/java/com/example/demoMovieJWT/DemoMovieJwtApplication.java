package com.example.demoMovieJWT;

import com.example.demoMovieJWT.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoMovieJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMovieJwtApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterregBean = new FilterRegistrationBean();
		filterregBean.setFilter(new JwtFilter());
		filterregBean.addUrlPatterns("/addMovie/*");
		return filterregBean;
	}

}
