package com.example.myblog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("buzz")
					.password("{noop}infinity")
					.authorities("ROLE_USER")
				.and()
					.withUser("woody")
						.password("{noop}bullseye")
						.authorities("ROLE_USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/admin/")
				.access("hasRole('ROLE_USER')")
			    .antMatchers("/","/**").access("permitAll")
			    
			   .and()
			   	.formLogin()
			    
			   .and()
			   .csrf()
			   	.ignoringAntMatchers("/h2-console/**")
			   	
			   .and()
			   	.headers()
			   		.frameOptions()
			   		.sameOrigin();
	}

		
}
