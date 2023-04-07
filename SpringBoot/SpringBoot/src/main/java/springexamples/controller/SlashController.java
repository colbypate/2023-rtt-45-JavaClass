package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;
import springexamples.formbeans.CreateUserFormBean;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleDAO userRoleDAO;

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

    @PostMapping("/signup")
    public ModelAndView setup(CreateUserFormBean form) {

        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller post method");

        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setFullName(form.getFullName());

        // this is needed by spring security to encrypt passwords as the user is being created
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        // saves our user... when hibernate saves this user it will autogenerate the PK
        // this line of code is saving the user to the database and populating the new PK id in the entity
        user = userDAO.save(user);

        // create our user role object
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());

        //when we go to set the user id FK on the user role entity the user id has been populate already
        userRoleDAO.save(userRole);

        log.debug(form.toString());
        
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
