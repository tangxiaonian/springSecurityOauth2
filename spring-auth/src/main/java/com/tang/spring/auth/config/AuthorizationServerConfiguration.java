package com.tang.spring.auth.config;

import com.tang.spring.auth.component.AuthExceptionEntryPoint;
import com.tang.spring.auth.component.CustomAccessDeniedHandler;
import com.tang.spring.auth.component.CustomWebResponseExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author ASUS
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Resource
    public AuthenticationManager authenticationManager;

    @Resource
    public CustomAccessDeniedHandler customAccessDeniedHandler;

    @Resource
    public AuthExceptionEntryPoint authExceptionEntryPoint;

    @Resource
    public CustomWebResponseExceptionTranslator customWebResponseExceptionTranslator;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // token 访问的接口进行暴露
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();

        security.authenticationEntryPoint(authExceptionEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler);
    }

    @Resource
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // 配置一个客户端
        clients.inMemory()
                .withClient("clientId")
                .secret(bCryptPasswordEncoder.encode("secret"))
                .scopes("backend")
                .authorizedGrantTypes("password","refresh_token")
                .accessTokenValiditySeconds(60 * 60 * 24)
                .refreshTokenValiditySeconds(60 * 60 * 24);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        // 必须的加，不然不能  密码模式
        endpoints.authenticationManager(authenticationManager);

        endpoints.exceptionTranslator(customWebResponseExceptionTranslator);
    }
}
