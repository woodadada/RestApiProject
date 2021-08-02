package com.jw.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	// Client 에 대한 정보를 설정하는 부분
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory() // 인메모리 저장
            .withClient("client") // 클라이언트 이름 작성
            .secret("{bcrypt} $2a$10$iP9ejueOGXO29.Yio7rqeuW9.yOC4YaV8fJp3eIWbP45eZSHFEwMG")  // password 문자를 암호화 한 것
            .redirectUris("http://localhost:8080/") // 리다이렉트 URI 설정
            .authorizedGrantTypes("authorization_code", "implicit", "password", "client_credentials") // Authorization Code Grant 타입을 설정
            .scopes("read"); // scope 지정
    }
	
	// OAuth2 인증 서버 자체의 보안 정보를 설정하는 부분
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		
		super.configure(security);
	}

	
}
