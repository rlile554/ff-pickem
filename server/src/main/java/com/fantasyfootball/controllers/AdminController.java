package com.fantasyfootball.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AdminController {
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String currentUserName(Principal principal) {
        return "admin";
    }
}