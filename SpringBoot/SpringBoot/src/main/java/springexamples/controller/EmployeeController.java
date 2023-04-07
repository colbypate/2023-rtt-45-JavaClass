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
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/detail");

        log.debug("In employee detail controller method with id = " + id);
        Employee employee = employeeDAO.findById(id);

        response.addObject("employee", employee);

        log.debug(employee + "");
        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("In employee controller - create employee");

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employee/create");
        log.debug("In employee controller - edit employee");

        Employee emp = employeeDAO.findById(id);
        EmployeeFormBean form = new EmployeeFormBean();

        // we are setting the employee id and all other employee fields on the form object
        // so that we can pass them to the jsp though the model
        form.setId(emp.getId());
        form.setEmail(emp.getEmail());
        form.setFirstName(emp.getFirstName());
        form.setLastName(emp.getLastName());
        form.setExtension(emp.getExtension());
        form.setJobTitle(emp.getJobTitle());
        form.setVacationHours(emp.getVacationHours());
        form.setOfficeId(emp.getOfficeId());
        form.setProfileImage(emp.getProfileImage());

        // add the form bean to the model to pass it to the jsp page
        response.addObject("form", form);

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(EmployeeFormBean form) {
        ModelAndView response = new ModelAndView("employee/create");

        List<Office> offices = officeDAO.getAllOffices();
        response.addObject("offices", offices);

        log.debug("!!!!!!!!!!!!!!! In employee controller - create submit employee");
        log.debug(form.toString());

        // creating a new database entity
        // and populating it with the incoming data from the form
        Employee emp = new Employee();

        // if the id is populated in teh form bean then it is an edit, so we want to load the
        // employee from the database
        if ( form.getId() != null && form.getId() > 0) {
            emp = employeeDAO.findById(form.getId());
        }

        // now we set all values from the form bean onto the employee object
        // !!! NOTE : we are not setting the id field here for 2 reasons
        // 1) If this is a create the database will auto generate the id
        // 2) If this is an edit we do not want to change the id (and it should be the same anyway)
        emp.setEmail(form.getEmail());
        emp.setFirstName(form.getFirstName());
        emp.setLastName(form.getLastName());
        emp.setExtension(form.getExtension());
        emp.setJobTitle(form.getJobTitle());
        emp.setVacationHours(form.getVacationHours());
        emp.setOfficeId(form.getOfficeId());
        emp.setProfileImage(form.getProfileImage());

        // in spring boot data there is only a single method called save that is used for both create and update
        employeeDAO.save(emp);

        // now we add the populated form back to the model so when page can display itself again
        response.addObject("form", form);

        // instead of processing a JSP view we can also redirect to another page
        // response.setViewName("redirect:/employee/edit/" + emp.getId());

        return response;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeFirstNameSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        log.debug("In the employee search controller method with search = " + firstName +" lastname: " + lastName);
        // modifying viewName to reflect folder structure where employee-search is
        ModelAndView response = new ModelAndView("employee/search");

        List<Employee> employees = new ArrayList<>();
//        List<Employee> employees = employeeDAO.usingANativeQuery(firstName, lastName);
//        List<Employee> employees = employeeDAO.usingJPAQuery(firstName, lastName);

        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            log.debug("first name and last name fields have a value");
            employees = employeeDAO.findByFirstNameContainingAndLastNameContainingIgnoreCase(firstName, lastName);
        }
        if(!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)){
            log.debug("first name field has a value and last name is empty");
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstName);
        }
        if(StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            log.debug("last name field has a value and first name is  empty");
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastName);
        }

        response.addObject("employeesList", employees);
        response.addObject("searchParamFirst", firstName);
        response.addObject("searchParamLast", lastName);

        return response;
    }

}