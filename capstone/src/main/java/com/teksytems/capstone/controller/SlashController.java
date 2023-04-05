package com.teksytems.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SlashController {
    @RequestMapping(value = {"/dashboard","/", "/dashboard.html"}, method = RequestMethod.GET)
    public ModelAndView dashboard() {
        log.info("Dashboard controller method:");
        ModelAndView response = new ModelAndView("dashboard");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */
        return response;
    }

    @RequestMapping(value = "/vendor", method = RequestMethod.GET)
    public ModelAndView vendor() {
        log.info("Vendor controller method:");
        ModelAndView response = new ModelAndView("vendor");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */
        return response;
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public ModelAndView inventory() {
        log.info("Inventory controller method:");
        ModelAndView response = new ModelAndView("inventory");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */
        return response;
    }

}
