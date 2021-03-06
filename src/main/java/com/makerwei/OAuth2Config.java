package com.makerwei;

import com.makerwei.service.UserMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Created by weixianbin on 16/10/31.
 */

public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserMangerService userService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.userDetailsService(userService);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().
                withClient("client")
                .authorizedGrantTypes("password", "authorization_code",
                        "refresh_token", "implicit")
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                .scopes("read", "write", "trust")
                .resourceIds(ResourceServer.RESOURCE_ID)
                .accessTokenValiditySeconds(300)
//                .and()
//                .withClient("my-client-with-registered-redirect")
//                .authorizedGrantTypes("authorization_code")
//                .authorities("ROLE_CLIENT")
//                .scopes("read", "trust").
//                resourceIds(ResourceServer.RESOURCE_ID)
//                .redirectUris("http://anywhere?key=value")
//                .and()
//                .withClient("my-client-with-secret")
//                .authorizedGrantTypes("client_credentials", "password")
//                .authorities("ROLE_CLIENT")
//                .scopes("read")
//                .resourceIds(ResourceServer.RESOURCE_ID)
                .secret("secret");
    }
}
