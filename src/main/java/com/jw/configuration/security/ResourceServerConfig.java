package com.jw.configuration.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and()
                .requestMatchers().antMatchers("/api/**");
        		//.access("#oauth2.hasScope('read')") 접속scope 설정 가능
       
    }
    
    @Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    	OAuth2AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        authenticationEntryPoint.setExceptionTranslator(resourceWebResponseExceptionTranslator());
        resources
                .authenticationEntryPoint(authenticationEntryPoint);
	}



	public WebResponseExceptionTranslator resourceWebResponseExceptionTranslator() {
    return new DefaultWebResponseExceptionTranslator() {

        @Override
        public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
            Map responseMap = new HashMap();
            String message = e.getMessage();
            String replaceMessage = message.replace("Invalid access token: ", "유효하지 않은 토큰입니다 : ");
            responseMap.put("message", replaceMessage);
            responseMap.put("code", HttpStatus.BAD_REQUEST.value());
        	return new ResponseEntity(responseMap, HttpStatus.UNAUTHORIZED);
        }
    };
}
}


