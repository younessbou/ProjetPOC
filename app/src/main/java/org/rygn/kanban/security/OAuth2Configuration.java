package org.rygn.kanban.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	
	@Value("${jwt.clientId}")
	private String clientId;

	@Value("${jwt.client-secret}")
	private String clientSecret;

	@Value("${jwt.signing-key}")
	private String jwtSigningKey;

	@Value("${jwt.accessTokenValidititySeconds}")
	private int accessTokenValiditySeconds;

	@Value("${jwt.authorizedGrantTypes}")
	private String[] authorizedGrantTypes;

	@Value("${jwt.refreshTokenValiditySeconds}")
	private int refreshTokenValiditySeconds;
	
	public OAuth2Configuration(PasswordEncoder passwordEncoder) {
		
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.accessTokenConverter(accessTokenConverter());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients
			.inMemory()
	        .withClient(clientId)
	        .secret(passwordEncoder.encode(clientSecret))
	        .accessTokenValiditySeconds(accessTokenValiditySeconds)
	        .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
	        .authorizedGrantTypes(authorizedGrantTypes)
	        .resourceIds("api");
	}
	
	@Bean
	JwtAccessTokenConverter accessTokenConverter() {
       JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
       return converter;
	}
}
