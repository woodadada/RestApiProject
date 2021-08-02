package com.jw.configuration.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http
	        .csrf().disable()
	        .authorizeRequests().antMatchers("/oauth/**", "/oauth2/callback").permitAll()
	        .anyRequest()
	        .authenticated()
	        .and()
	        .formLogin().and()
	        .httpBasic();
    }
}
