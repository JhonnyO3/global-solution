package com.fiap.global.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//API V1.0

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class GlobalSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalSolutionApplication.class, args);
	}

}
