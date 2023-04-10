package com.teksytems.capstone.controller;

import com.teksytems.capstone.database.dao.UserDAO;
import com.teksytems.capstone.database.entity.User;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        log.info("Login in the User controller method:");
        ModelAndView response = new ModelAndView("user/login");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */

        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        log.info("Register in the User controller method:");
        ModelAndView response = new ModelAndView("user/register");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */

        List<String> jobs = userDAO.getAllJobs();
        response.addObject("jobs", jobs);

        return response;
    }

    @RequestMapping(value="/edit{id}", method=RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("user/register");


        return response;
    }
    
}
