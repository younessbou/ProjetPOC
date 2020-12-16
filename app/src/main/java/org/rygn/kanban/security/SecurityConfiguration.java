package org.rygn.kanban.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
        .antMatchers(HttpMethod.POST, "/oauth/**").permitAll()
        .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
        .anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity
				.ignoring()
				.antMatchers(HttpMethod.GET, "/actuator")
				.antMatchers(HttpMethod.GET, "/actuator/**")
				.antMatchers("/v2/api-docs",
				"/swagger-resources/**",
				"/swagger-ui.html",
				"/webjars/**");
	}
}
