package com.fantasyfootball.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal currentUserName(Principal principal) {
        return principal;
    }
}
