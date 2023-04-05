package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;

@Slf4j
@Controller
public class SlashController {
    @RequestMapping(value = {"/index","/", "/index.html"}, method = RequestMethod.GET)
    public ModelAndView index() {
        log.debug("Index controller method:");
        ModelAndView response = new ModelAndView("index");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */

        log.trace("This is a trace log example");
        log.debug("This is a debug log example");
        log.info("This is an info log example");
        log.warn("This is a warn log example");
        log.error("This is an error log example");

        return response;
    }
    @GetMapping("/signup")
    public ModelAndView signup() {
        log.debug("Signup controller method:");
        ModelAndView response = new ModelAndView("signup");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */
        return response;
    }
    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ModelAndView bootstrap() {
        log.debug("Bootstrap controller method:");
        ModelAndView response = new ModelAndView("bootstrap");
        /* the index name in the ModelAndView is the name of the jsp file without the extension */
        return response;
    }

}
