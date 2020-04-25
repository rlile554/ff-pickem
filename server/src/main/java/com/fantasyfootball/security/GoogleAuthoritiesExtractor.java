package com.fantasyfootball.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import java.util.*;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.stereotype.Component;

@Component
public class GoogleAuthoritiesExtractor implements AuthoritiesExtractor {
    private List<GrantedAuthority> USER_AUTHORITIES = AuthorityUtils
            .commaSeparatedStringToAuthorityList("ROLE_USER");
    private List<GrantedAuthority> ADMIN_AUTHORITIES = AuthorityUtils
            .commaSeparatedStringToAuthorityList("ROLE_ADMIN");

    @Override
    public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
        System.out.println("hello");
        if (Objects.nonNull(map.get("plan"))) {
            if (!((LinkedHashMap) map.get("plan"))
                    .get("name")
                    .equals("free")) {
                return USER_AUTHORITIES;
            }
        }
    return ADMIN_AUTHORITIES;
    }
}
