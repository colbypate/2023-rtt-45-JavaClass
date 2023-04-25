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

    // @RequestMapping(value = "/search", method = RequestMethod.GET)
    // public ModelAndView findOrdersBy(@RequestParam(required = false) Integer id) {
    //     log.debug("In the orders search controller method with search = " + id);
    //     // modifying viewName to reflect folder structure where employee-search is
    //     ModelAndView response = new ModelAndView("orders/search");
    //     //Added this user so that i can display the user name that made each order(may not work need to check)
    //     User user = authenticatedUserService.loadCurrentUser();
    //     List<Orders> orders = new ArrayList<>();
    //     orders = ordersDAO.getAllOrders();

    //     if (id != null) {
    //         log.debug("Searching for orders by id = " + id);
    //         Orders order = ordersDAO.findOrderById(id);
    //         if (order != null) {
    //             orders.add(order);
    //         }
    //     }

    //     response.addObject("orderList", orders);
    //     response.addObject("user", user);

    //     return response;
    // }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView findInventoriesByProductName(@RequestParam(required = false) String productName) {
        log.debug("In the Inventory search controller method with search = " + productName);
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


    // @GetMapping("/create")
    // public ModelAndView register() {
    //     ModelAndView response = new ModelAndView("orders/create");
    //     log.debug("In user controller - create user");

    //     return response;
    // }


    @RequestMapping(value = {"/addToCart"}, method = RequestMethod.GET)
    public ModelAndView addtocart(@RequestParam(required = false) Integer id) {
        log.debug("In the addtocart controller method.");
        ModelAndView response = new ModelAndView("redirect:/orders/create/" + id);

        Inventory inventory = inventoryDAO.findById(id);

        User user = authenticatedUserService.loadCurrentUser();

        Orders order = ordersDAO.findByStatusEqualsCartAndUserId(user.getId());

        if (order == null) {

            order = new Orders();
            order.setStatus("Cart");
            order.setUser(user);
            order.setOrderDate(new Date());
            ordersDAO.save(order);
        }

        OrderDetails orderDetails = orderDetailsDAO.findByOrderIdAndInventoryId(order.getId(), inventory.getId());

        // 6) if it exists then increment the quantity by 1 otherwise create it with quantity = 1
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

    @RequestMapping(value = {"/removefromcart"}, method = RequestMethod.GET)
    // 1) incoming argument to controller is the product_id
    public ModelAndView removefromcart(@RequestParam(required = true) Integer id) {
        log.debug("In the removefromcart controller method.");
        ModelAndView response = new ModelAndView();

        Inventory inventory = inventoryDAO.findById(id);

        User user = authenticatedUserService.loadCurrentUser();

        // does making a new orders here wipe whatever was previously established?
        // 3) query for an order where status = "cart" and user_id = "logged in user id"
        Orders order = ordersDAO.findByStatusEqualsCartAndUserId(user.getId());

        // 5) use the product_id and the order id to create query for the order product
        OrderDetails orderDetails = orderDetailsDAO.findByOrderIdAndInventoryId(order.getId(), inventory.getId());

        orderDetailsDAO.removeFromCartByOrderIdAndInventoryId(order.getId(), inventory.getId());

        orderDetailsDAO.save(orderDetails);
        response.setViewName("redirect:/order/viewcart");
        return response;
    }

    @RequestMapping(value = {"/viewcart"}, method = RequestMethod.GET)
    public ModelAndView viewcart() {
        log.debug("In the viewcart controller method.");
        ModelAndView response = new ModelAndView("orders/viewcart");

        User user = authenticatedUserService.loadCurrentUser();

        List<Map<String,Object>> orderDetails = ordersDAO.findCartProductsByUserId(user.getId());

        response.addObject("orderDetailsList", orderDetails);

        return response;
    }

    @RequestMapping(value = {"/submitOrder"}, method = RequestMethod.GET)
    public ModelAndView submitOrder() {
        log.debug("In the submitOrder controller method.");
        ModelAndView response = new ModelAndView();

        User user = authenticatedUserService.loadCurrentUser();

        Orders order = ordersDAO.findByStatusEqualsCartAndUserId(user.getId());

        order.setStatus("Complete");
        ordersDAO.save(order);

        response.setViewName("redirect:/orders/ordercomplete");
        return response;

    }

    @RequestMapping(value = {"/ordercomplete"}, method = RequestMethod.GET)
    public ModelAndView ordercomplete() {
        log.debug("In the ordercomplete controller method.");
        ModelAndView response = new ModelAndView("orders/ordercomplete");
        return response;
    }

    @GetMapping("/pastorders")
    public ModelAndView pastorders() {
        ModelAndView response = new ModelAndView("orders/pastorders");
        User user = authenticatedUserService.loadCurrentUser();


        log.debug("In pastorders controller method");
        List<Map<String,Object>> order = ordersDAO.findPastOrdersByUserId(user.getId());

        // this allows for the employee details to appear on the details page
        response.addObject("order", order);

        log.debug(order + "");
        return response;
    }

    }

   
