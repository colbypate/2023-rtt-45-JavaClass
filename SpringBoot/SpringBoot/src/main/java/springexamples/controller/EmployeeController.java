package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.List;

@Controller
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        log.info("Employee search controller method with search = " + firstName + lastName);
        ModelAndView response = new ModelAndView("employee/employee-search");

        List<Employee> employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        response.addObject("employeesList", employees);
        response.addObject("firstName", firstName);
        response.addObject("lastName", lastName);
        return response;
    }
}
