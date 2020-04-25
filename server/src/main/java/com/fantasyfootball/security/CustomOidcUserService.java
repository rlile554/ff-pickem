package com.fantasyfootball.security;

import com.fantasyfootball.dto.GoogleOAuth2UserInfo;
import com.fantasyfootball.model.User;
import com.fantasyfootball.repos.UserRepository;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomOidcUserService extends OidcUserService {

    private final UserRepository userRepository;

    public CustomOidcUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        Map attributes = oidcUser.getAttributes();
        GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo();
        userInfo.setEmail((String) attributes.get("email"));
        userInfo.setId((String) attributes.get("sub"));
        userInfo.setName((String) attributes.get("name"));
        updateUser(userInfo, oidcUser.getAuthorities().toArray()[0].toString());
        return oidcUser;
    }

    private void updateUser(GoogleOAuth2UserInfo userInfo, String role) {
        Optional userOptional = userRepository.findByEmail(userInfo.getEmail());
        if(userOptional.isPresent()){
            return;
        }
        User user = new User();
        user.setRole(role);
        user.setEmail(userInfo.getEmail());
        user.setName(userInfo.getName());
        userRepository.save(user);
    }
}
