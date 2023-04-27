package com.teksytems.capstone.controller;

import com.teksytems.capstone.formbeans.UserFormBean;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.teksytems.capstone.database.dao.InventoryDAO;
import com.teksytems.capstone.database.dao.UserDAO;
import com.teksytems.capstone.database.entity.Inventory;
import com.teksytems.capstone.formbeans.InventoryFormBean;
import com.teksytems.capstone.security.AuthenticatedUserService;

import io.micrometer.common.util.StringUtils;

@Slf4j
@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private InventoryDAO inventoryDAO;

    @GetMapping("/allInventory")
    public ModelAndView inventory() {
        ModelAndView response = new ModelAndView("inventory/inventory");

        log.debug("In inventory controller method:");
        List<Inventory> inventory = inventoryDAO.getAllInventories();

        response.addObject("inevntory", inventory);

        log.debug(inventory + "");
        return response;
    }

//     @RequestMapping(value = "/search", method = RequestMethod.GET)
//     public ModelAndView inventoryProductNameSearch (@RequestParam(required = false) String productName) {
//         log.debug("In the inventory search controller method with search = " + productName);
//         // modifying viewName to reflect folder structure where employee-search is
//         ModelAndView response = new ModelAndView("inventory/search");

//         List<Inventory> inventory = new ArrayList<>();
// //        List<Employee> employees = employeeDAO.usingANativeQuery(firstName, lastName);
// //        List<Employee> employees = employeeDAO.usingJPAQuery(firstName, lastName);

//         if(!StringUtils.isEmpty(productName)){
//             log.debug("first name and last name fields have a value");
//             inventory = inventoryDAO.findInventoriesByProductName(productName);
//         }

//         response.addObject("employeesList", inventory);

//         return response;
//     }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView findInventoriesByProductName(@RequestParam(required = false) String productName) {
        log.debug("In the Inventory search controller method with search = " + productName);
        // modifying viewName to reflect folder structure where employee-search is
        ModelAndView response = new ModelAndView("inventory/search");

        List<Inventory> inventory = new ArrayList<>();
        inventory = inventoryDAO.findInventoryByProductName(productName);

        if (!StringUtils.isEmpty(productName)) {
            log.debug("first name and last name fields have a value");
            inventory = inventoryDAO.findInventoryByProductName(productName);
        }
        if (StringUtils.isEmpty(productName)) {
            log.debug("last name field has a value and first name is  empty");
            inventory = inventoryDAO.getAllInventories();
        }

        response.addObject("inventoryList", inventory);
        response.addObject("searchParam", productName);

        return response;
    }

    @GetMapping("/details/{productName}")
    public ModelAndView detail(@PathVariable String productName) {
        ModelAndView response = new ModelAndView("inventory/details");

        log.debug("In inventory detail controller method with name = " + productName);
        Inventory inventory = inventoryDAO.findInventoryByProductNameExact(productName);

        response.addObject("inventory", inventory);

        log.debug(inventory + "");
        return response;
    }

    // @GetMapping("/edit")
    // public ModelAndView editInventory() {
    //     ModelAndView response = new ModelAndView("inventory/details");

    //     log.debug("In inventory detail controller method with name = " + inventoryId);
    //     Inventory inventory = inventoryDAO.findById(inventoryId);

    //     response.addObject("inventory", inventory);

    //     log.debug(inventory + "");
    //     return response;
    // }

    @GetMapping("/edit/{inventoryId}")
    public ModelAndView edit(@PathVariable Integer inventoryId) {
        ModelAndView response = new ModelAndView("inventory/edit");

        log.debug("In inventory edit controller method with name = " + inventoryId);
        Inventory inventory = inventoryDAO.findById(inventoryId);
        InventoryFormBean form = new InventoryFormBean();

        form.setId(inventory.getId());
        form.setProductName(inventory.getProductName());
        form.setQuantity(inventory.getQuantity());
        form.setPrice(inventory.getPrice());
        form.setPhotoURL(inventory.getPhotoURL());

        response.addObject("form", form);
        return response;
    }

    @PostMapping("/editSubmit")
    public ModelAndView editSubmit(InventoryFormBean form) throws IOException {
        ModelAndView response = new ModelAndView("inventory/edit");

        log.debug("In the inventory controller - edit submit method");
        log.debug(form.toString());

        Inventory inventory = new Inventory();


        if (form.getId() != null && form.getId() > 0) {
            inventory = inventoryDAO.findById(form.getId());
        }

        inventory.setId(form.getId());
        inventory.setProductName(form.getProductName());
        inventory.setQuantity(form.getQuantity());
        inventory.setPrice(form.getPrice());
        inventory.setPhotoURL(form.getPhotoURL());


        inventoryDAO.save(inventory);

        //now we add the populated form back to the model so when page can display itself again
        response.setViewName("redirect:/inventory/search");


        return response;
    }

    @GetMapping("/create")
    public ModelAndView create(@Valid InventoryFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView("inventory/create");

        //log.debug("In inventory create controller method with name = " + inventoryId);
        //Inventory inventory = inventoryDAO.findById(inventoryId);
        Inventory inventory = new Inventory();

        inventory.setId(form.getId());
        inventory.setProductName(form.getProductName());
        inventory.setQuantity(form.getQuantity());
        inventory.setPrice(form.getPrice());
        inventory.setPhotoURL(form.getPhotoURL());

        response.addObject("form", form);
        
        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(InventoryFormBean form) throws IOException {
        ModelAndView response = new ModelAndView("inventory/edit");

        log.debug("In the inventory controller - edit submit method");
        log.debug(form.toString());

        Inventory inventory = new Inventory();


        if (form.getId() != null && form.getId() > 0) {
            inventory = inventoryDAO.findById(form.getId());
        }

        inventory.setId(form.getId());
        inventory.setProductName(form.getProductName());
        inventory.setQuantity(form.getQuantity());
        inventory.setPrice(form.getPrice());
        inventory.setPhotoURL(form.getPhotoURL());


        inventoryDAO.save(inventory);

        //now we add the populated form back to the model so when page can display itself again
        response.setViewName("redirect:/inventory/search");


        return response;
    }


}
