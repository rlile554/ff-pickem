package com.fantasyfootball.security;

import com.fantasyfootball.dto.GoogleOAuth2UserInfo;
import com.fantasyfootball.model.User;
import com.fantasyfootball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomOidcUserService extends OidcUserService {

    @Autowired
    private UserService userService;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        Map attributes = oidcUser.getAttributes();
        GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo();
        userInfo.setEmail((String) attributes.get("email"));
        userInfo.setId((String) attributes.get("sub"));
        userInfo.setImageUrl((String) attributes.get("picture"));
        userInfo.setName((String) attributes.get("name"));
        updateUser(userInfo);
        return oidcUser;
    }

    private void updateUser(GoogleOAuth2UserInfo userInfo) {
        Optional<User> user = userService.findByEmail(userInfo.getEmail());
        String adminListString = System.getenv("admin_list");
        String[] str = adminListString.split(",");
        List<String> adminListArray = Arrays.asList(str);
        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(userInfo.getEmail());
            newUser.setName(userInfo.getName());
            if(adminListArray.contains(userInfo.getEmail())){
                newUser.setRole("ROLE_ADMIN");
            } else {
                newUser.setRole("ROLE_USER");
            }
            userService.create(newUser);
        }
    }
}
