package com.teksytems.capstone.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.teksytems.capstone.database.dao.InventoryDAO;
import com.teksytems.capstone.database.dao.UserDAO;
import com.teksytems.capstone.database.entity.Inventory;

import io.micrometer.common.util.StringUtils;

@Slf4j
@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private InventoryDAO inventoryDAO;

    @GetMapping("/allInventory")
    public ModelAndView  inventory(){
        ModelAndView response = new ModelAndView("/inventory/inventory");

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

        if(!StringUtils.isEmpty(productName)){
            log.debug("first name and last name fields have a value");
            inventory = inventoryDAO.findInventoryByProductName(productName);
        }
        if(StringUtils.isEmpty(productName)){
            log.debug("last name field has a value and first name is  empty");
            inventory = inventoryDAO.findInventoryByProductName(productName);
        }

        response.addObject("inventoryList", inventory);
        response.addObject("searchParam", productName);

        return response;
    }

    @GetMapping("/details/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("inventory/detail");

        log.debug("In employee detail controller method with id = " + id);
        Inventory inventory = inventoryDAO.findInventoryById(id);

        response.addObject("inventory", inventory);

        log.debug(inventory + "");
        return response;
    }

    
}
