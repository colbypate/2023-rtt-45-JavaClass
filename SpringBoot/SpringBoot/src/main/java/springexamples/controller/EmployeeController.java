package springexamples.controller;

import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id){
        ModelAndView response = new ModelAndView("employee/detail");
        log.info("In employee detail controller method with id = "+ id);
        Employee employee = employeeDAO.findById(id);
        log.info(employee + "");
        response.addObject("employee",employee);
        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        log.info("Employee search controller method with search = " + firstName + lastName);
        ModelAndView response = new ModelAndView("employee/search");

        List<Employee> employees = new ArrayList<>();
        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        }
        if(!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)){
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstName);
        }
        if(StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastName);
        }

        response.addObject("employeesList", employees);
        response.addObject("firstName", firstName);
        response.addObject("lastName", lastName);
        return response;
    }
}
