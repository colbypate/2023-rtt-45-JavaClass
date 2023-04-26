package com.teksytems.capstone.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.wls.shaded.org.apache.xalan.lib.Redirect;
import com.teksytems.capstone.database.dao.InventoryDAO;
import com.teksytems.capstone.database.dao.OrderDetailsDAO;
import com.teksytems.capstone.database.dao.OrdersDAO;
import com.teksytems.capstone.database.dao.UserDAO;
import com.teksytems.capstone.database.dao.UserRolesDAO;
import com.teksytems.capstone.database.entity.Inventory;
import com.teksytems.capstone.database.entity.OrderDetails;
import com.teksytems.capstone.database.entity.Orders;
import com.teksytems.capstone.database.entity.User;
import com.teksytems.capstone.formbeans.OrderFormBean;
import com.teksytems.capstone.security.AuthenticatedUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/orders")
@Controller
public class OrderController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRolesDAO userRoleDAO;

    @Autowired
    private OrdersDAO ordersDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private InventoryDAO inventoryDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView findOrdersBy(@RequestParam(required = false) Integer id) {
        log.debug("In the orders search controller method with search = " + id);
        // modifying viewName to reflect folder structure where employee-search is
        ModelAndView response = new ModelAndView("orders/search");
        //Added this user so that i can display the user name that made each order(may not work need to check)
        User user = authenticatedUserService.loadCurrentUser();
        List<Orders> orders = new ArrayList<>();
        orders = ordersDAO.getAllOrders();

        if (id != null) {
            log.debug("Searching for orders by id = " + id);
            Orders order = ordersDAO.findOrderById(id);
            if (order != null) {
                orders.add(order);
            }
        }

        response.addObject("orderList", orders);
        response.addObject("user", user);

        return response;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView findInventoriesByProductName(@RequestParam(required = false) String productName) {
        log.debug("In the Order search controller method with search = " + productName);
        // modifying viewName to reflect folder structure where employee-search is
        ModelAndView response = new ModelAndView("orders/create");

        List<Inventory> inventory = new ArrayList<>();
        inventory = inventoryDAO.findInventoryByProductName(productName);

        if(!StringUtils.isEmpty(productName)){
            log.debug("first name and last name fields have a value");
            inventory = inventoryDAO.findInventoryByProductName(productName);
        }
        if(StringUtils.isEmpty(productName)){
            log.debug("last name field has a value and first name is  empty");
            inventory = inventoryDAO.getAllInventories();
        }

        response.addObject("inventoryList", inventory);
        response.addObject("searchParam", productName);

        return response;
    }

    @GetMapping("/details/{id}")
    public ModelAndView detail(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("orders/details");

        log.debug("In employee detail controller method with id = " + id);
        Orders orders = ordersDAO.findOrderById(id);

        response.addObject("orders", orders);

        log.debug(orders + "");
        return response;
    }



    @GetMapping("/viewCart")
    public ModelAndView viewCart() {
        log.debug("In the view cart controller method");
        ModelAndView response = new ModelAndView("orders/cart");

        User user = authenticatedUserService.loadCurrentUser();
        //Order order = new Order();
        //order.setUser(user);

        List<Map<String,Object>> productList = ordersDAO.findCartProductsByUserId(user.getId());

        boolean hasProduct = false;
        if(!productList.isEmpty()){
            hasProduct = true;
        }
        response.addObject("hasProducts", hasProduct);

        response.addObject("productList", productList);
        return response;
    }


    @RequestMapping(value = {"/addToCart"}, method = RequestMethod.GET)
    public ModelAndView addtocart(@RequestParam(required = false) Integer inventoryId) {
        log.debug("In the addtocart controller method.");
        ModelAndView response = new ModelAndView("redirect:/orders/create");
        // "redirect:/orders/create/" + id

        Inventory inventory = inventoryDAO.findById(inventoryId);

        User user = authenticatedUserService.loadCurrentUser();

        Orders order = ordersDAO.findOrderByStatusAndUserId(user.getId());

        if (order == null) {

            order = new Orders();
            order.setStatus("Cart");
            order.setUser(user);
            order.setOrderDate(new Date());
            ordersDAO.save(order);
        }

        OrderDetails orderDetails = orderDetailsDAO.findByOrderIdAndInventoryId(order.getId(), inventory.getId());

        if (orderDetails == null) {
            orderDetails = new OrderDetails();
            orderDetails.setQuantity(1);
            orderDetails.setInventory(inventory);
            orderDetails.setOrders(order);
        } else {
            orderDetails.setQuantity(orderDetails.getQuantity() + 1);
        }
        orderDetailsDAO.save(orderDetails);
        // response.setViewName("redirect:/orders/viewcart");
        return response;
    }

    @RequestMapping(value ={"/submitOrder"}, method = RequestMethod.GET)
    public ModelAndView checkout() {
        log.debug("In the submit order method");

        ModelAndView response = new ModelAndView("redirect:/dashboard");

        User user = authenticatedUserService.loadCurrentUser();

        Orders order = ordersDAO.findOrderByStatusAndUserId(user.getId());
        order.setStatus("Complete");
        ordersDAO.save(order);

        return response;


    }

    @RequestMapping(value ={"/deleteFromCart"}, method = RequestMethod.GET)
    public ModelAndView productSearch(@RequestParam(required = true) Integer inventoryId) {
        log.debug("In the delete from cart method");


        ModelAndView response = new ModelAndView("redirect:/orders/viewCart");

        Inventory inventory = inventoryDAO.findById(inventoryId);

        orderDetailsDAO.deleteFromCart(inventoryId);
        response.addObject("inventory", inventory);
        return response;


    }



    }

   
