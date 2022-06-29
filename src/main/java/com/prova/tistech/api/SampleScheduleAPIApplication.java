package com.prova.tistech.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.prova.tistech.api.security.JWTAuthorizationFilter;

@EnableTransactionManagement
@SpringBootApplication
public class SampleScheduleAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleScheduleAPIApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security"
							,"/swagger-ui.html", "/webjars/**","/swagger-resources/configuration/ui","/swagger-ui.html"
							,"/swagger-resources/**" , "/h2-console", "/h2-console/**").permitAll()
					.antMatchers(HttpMethod.POST, "/user").permitAll()
					.anyRequest().authenticated();
		}
	}
}