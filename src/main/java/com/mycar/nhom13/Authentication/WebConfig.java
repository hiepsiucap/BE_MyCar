package com.mycar.nhom13.Authentication;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpHeaders.ORIGIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
	@Bean
	public CorsFilter corsFilter() {
		var urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		var corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(List.of(
			"http://localhost:8080", 
			"http://localhost:3000",
				"https://d39wbnvl8pysap.cloudfront.net/",
			"https://d39wbnvl8pysap.cloudfront.net",
			"https://staging.d25yrxnhs8vh9u.amplifyapp.com"
		));
		corsConfiguration.setAllowedHeaders(List.of(
			ORIGIN, 
			ACCESS_CONTROL_ALLOW_ORIGIN, 
			CONTENT_TYPE, 
			ACCEPT,
			AUTHORIZATION, 
			"X-Requested-With", 
			ACCESS_CONTROL_REQUEST_METHOD, 
			ACCESS_CONTROL_REQUEST_HEADERS,
			ACCESS_CONTROL_ALLOW_CREDENTIALS
		));
		corsConfiguration.setExposedHeaders(List.of(
			ORIGIN, 
			ACCESS_CONTROL_ALLOW_ORIGIN, 
			CONTENT_TYPE, 
			ACCEPT,
			AUTHORIZATION, 
			"X-Requested-With", 
			ACCESS_CONTROL_REQUEST_METHOD, 
			ACCESS_CONTROL_REQUEST_HEADERS,
			ACCESS_CONTROL_ALLOW_CREDENTIALS,
			"Set-Cookie"
		));
		corsConfiguration.setAllowedMethods(List.of(
			GET.name(), 
			POST.name(), 
			PUT.name(), 
			PATCH.name(), 
			DELETE.name(), 
			OPTIONS.name()
		));
		
		// Thêm cấu hình cho cookie
		corsConfiguration.setAllowCredentials(true);
		
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
