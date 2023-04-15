package com.teksytems.capstone.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

//this makes it so that only users with admin authority can access these pages

public class LoginController {
    @GetMapping("/login/loginPage")
    public ModelAndView setup() {
        log.debug("In the login controller method");
        ModelAndView response = new ModelAndView("login/login");

        return response;
    }
}
