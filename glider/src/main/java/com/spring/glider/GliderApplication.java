package com.spring.glider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GliderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GliderApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplateObject() {
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate;
	}
}
