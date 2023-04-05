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
import springexamples.database.dao.OfficeDAO;
import springexamples.database.entity.Employee;
import springexamples.database.entity.Office;
import springexamples.formbeans.EmployeeFormBean;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private OfficeDAO officeDAO;

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id){
        ModelAndView response = new ModelAndView("employee/detail");
        log.info("In employee detail controller method with id = "+ id);
        Employee employee = employeeDAO.findById(id);
        log.info(employee + "");
        response.addObject("employee",employee);
        return response;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("In employee controller- create employee");
        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);
        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id){
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("In employee controller- edit employee");

        Employee emp = employeeDAO.findById(id);
        EmployeeFormBean form = new EmployeeFormBean();

        form.setId(emp.getId());
        form.setFirstName(emp.getFirstName());
        form.setLastName(emp.getLastName());
        form.setEmail(emp.getEmail());
        form.setExtension(emp.getExtension());
        form.setJobTitle(emp.getJobTitle());
        form.setVacationHours(emp.getVacationHours());
        form.setOfficeId(emp.getOfficeId());
        form.setProfileImage(emp.getProfileImage());

        response.addObject("form", form);

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);
        return response;
    }
    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(EmployeeFormBean form){
        ModelAndView response = new ModelAndView("employee/create");

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);


        log.debug("!!!!!!!!! In employee controller- create and submit employee");
        log.debug(form.toString());

        Employee emp = new Employee();

        if(form.getId() != null && form.getId() > 0){
            emp = employeeDAO.findById(form.getId());
        }

        //we are not setting the id here because it will auto generate or if we are just editing a user
        //they will already have an id
        emp.setFirstName(form.getFirstName());
        emp.setLastName(form.getLastName());
        emp.setEmail(form.getEmail());
        emp.setExtension(form.getExtension());
        emp.setJobTitle(form.getJobTitle());
        emp.setVacationHours(form.getVacationHours());
        emp.setOfficeId(form.getOfficeId());
        emp.setProfileImage(form.getProfileImage());

        //in spring boot save acts as a create and update
        employeeDAO.save(emp);
        response.addObject("form", form);
        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        log.debug("Employee search controller method with search = " + firstName + lastName);
        ModelAndView response = new ModelAndView("employee/search");

        List<Employee> employees = new ArrayList<>();
        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            employees = employeeDAO.findByFirstNameContainingAndLastNameContainingIgnoreCase(firstName, lastName);
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
