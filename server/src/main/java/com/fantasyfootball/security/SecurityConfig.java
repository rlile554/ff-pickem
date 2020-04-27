package com.fantasyfootball.security;

import com.fantasyfootball.model.User;
import com.fantasyfootball.repos.UserRepository;
import com.fantasyfootball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;

import java.util.*;

@Configuration
//@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OidcUserService oidcUserService;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated().and()
                .oauth2Login()
                .userInfoEndpoint()
                .oidcUserService(oidcUserService);
    }

    @Bean
    public GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return (authorities) -> {
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            OidcUserAuthority userAuthority = (OidcUserAuthority)authorities.toArray()[0];
            String email = userAuthority.getAttributes().get("email").toString();
            Optional<User> user = userService.findByEmail(email);
            if(user.isPresent()){
                OidcUserAuthority newUserAuthority = new OidcUserAuthority(user.get().getRole(), userAuthority.getIdToken(),
                        userAuthority.getUserInfo());
                mappedAuthorities.add(newUserAuthority);
            }
            return mappedAuthorities;
        };
    }
}
