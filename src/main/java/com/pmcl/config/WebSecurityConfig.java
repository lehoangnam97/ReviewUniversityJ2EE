//package com.pmcl.config;
//
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//public class WebSecurityConfig {
//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilter() {
//		System.out.print("Go to filter : ");
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
//		bean.setOrder(0);
//		return bean;
//	}
//}