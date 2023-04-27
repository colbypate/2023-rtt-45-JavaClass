package com.teksytems.capstone.controller;

import com.teksytems.capstone.database.dao.UserDAO;
import com.teksytems.capstone.database.dao.UserRolesDAO;
import com.teksytems.capstone.database.entity.User;
import com.teksytems.capstone.database.entity.UserRoles;
import com.teksytems.capstone.formbeans.UserFormBean;
import com.teksytems.capstone.security.AuthenticatedUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private UserRolesDAO userRolesDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/details")
    public ModelAndView detail() {

        ModelAndView response = new ModelAndView("user/details");

        User user = authenticatedUserService.loadCurrentUser();
        log.debug("In user detail controller method with id = " + user.getId());


        response.addObject("user", user);

        log.debug(user + "");
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeFirstNameSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        log.debug("In the user search controller method with search = " + firstName + " lastname: " + lastName);
        // modifying viewName to reflect folder structure where employee-search is
        ModelAndView response = new ModelAndView("user/search");

        List<User> users = new ArrayList<>();

        users = userDAO.getAllUsers();

        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            log.debug("first name and last name fields have a value");
            users = userDAO.findByFirstNameContainingAndLastNameContainingIgnoreCase(firstName, lastName);
        }
        if (!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            log.debug("first name field has a value and last name is empty");
            users = userDAO.findByFirstNameContainingIgnoreCase(firstName);
        }
        if (StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            log.debug("last name field has a value and first name is  empty");
            users = userDAO.findByLastNameContainingIgnoreCase(lastName);
        }

        response.addObject("usersList", users);
        response.addObject("searchParamFirst", firstName);
        response.addObject("searchParamLast", lastName);

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("user/register");


        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView response = new ModelAndView("user/register");
        log.debug("In user controller - create user");

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/registerSubmit")
    public ModelAndView registerSubmit(@Valid UserFormBean form, BindingResult bindingResult, HttpSession session) {

        ModelAndView response = new ModelAndView("user/register");
        log.debug("In the register user controller post method");


        if (StringUtils.equals(form.getPassword(), form.getConfirmPassword()) == false) {
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
        }

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field: " + error.getField());

                log.debug("Validation Error Message: " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            return response;
        }

        // first we create our user
        User user = new User();
//        user.setId(form.getId());
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setJob(form.getJob());

        // this is needed by spring security to encrypt passwords as the user is being created.
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        // save our user .. when hibernate saves this user it will auto generate PK
        // this line of code is doing 2 things .. saving the user to the database and populating the new PK id in the entity
        userDAO.save(user);

        // create our user role object
        UserRoles userRole = new UserRoles();
        // we are going to hard code the default user role to be "USER"
        userRole.setRoleName("USER");
        // so when we go to set the user id FK on the user role entity the user id has been populated already.

        userRole.setUserId(user.getId());

        userRolesDAO.create(user.getId());

        // very important that this line of code is after both the user and the user role is saved to the database
        // authenticate the user that was just created
        //authenticatedUserService.changeLoggedInUsername(session, form.getEmail(), form.getPassword());
        response.addObject("form", form);
        response.addObject("success", true);

        log.debug(form.toString());

        return response;
    }

}
