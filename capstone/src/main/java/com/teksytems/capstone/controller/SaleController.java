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
import com.teksytems.capstone.database.dao.SaleDetailsDAO;
import com.teksytems.capstone.database.dao.SalesDAO;
import com.teksytems.capstone.database.dao.UserDAO;
import com.teksytems.capstone.database.dao.UserRolesDAO;
import com.teksytems.capstone.database.entity.Inventory;
import com.teksytems.capstone.database.entity.SaleDetails;
import com.teksytems.capstone.database.entity.Sales;
import com.teksytems.capstone.database.entity.User;
import com.teksytems.capstone.formbeans.OrderFormBean;
import com.teksytems.capstone.security.AuthenticatedUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/sales")
@Controller
public class SaleController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRolesDAO userRoleDAO;

    @Autowired
    private SalesDAO salesDAO;

    @Autowired
    private SaleDetailsDAO saleDetailsDAO;

    @Autowired
    private InventoryDAO inventoryDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView findOrderById(@RequestParam(required = false) Integer id) {
        log.debug("In the sales search controller method with search = " + id);
        // modifying viewName to reflect folder structure where employee-search is
        ModelAndView response = new ModelAndView("orders/search");
        //Added this user so that i can display the user name that made each order(may not work need to check)
        List<Sales> sales = new ArrayList<>();
        sales = salesDAO.findSalesById(id);

        if (id != null) {
            log.debug("Searching for sales by id = " + id);
            sales = salesDAO.findSalesById(id);
        }
        if (id == null) {
            sales = salesDAO.getAllSales();
        }


        response.addObject("saleList", sales);
        response.addObject("saleId", id);

        return response;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView findInventoriesByProductName(@RequestParam(required = false) String productName) {
        log.debug("In the Order search controller method with search = " + productName);
        // modifying viewName to reflect folder structure where employee-search is
        ModelAndView response = new ModelAndView("sales/create");

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

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("sales/details");

        log.debug("In sales detail controller method with id = " + id);
        List<Sales> sales = salesDAO.findSalesById(id);

        response.addObject("sales", sales);

        log.debug(sales + "");
        return response;
    }


    @GetMapping("/viewInvoice")
    public ModelAndView viewInvoice() {
        log.debug("In the view Incoice controller method");
        ModelAndView response = new ModelAndView("sales/invoice");

        User user = authenticatedUserService.loadCurrentUser();

        List<Map<String, Object>> productList = salesDAO.findInvoiceProductsByUserId(user.getId());

        boolean hasProduct = false;
        if (!productList.isEmpty()) {
            hasProduct = true;
        }
        response.addObject("hasProducts", hasProduct);

        response.addObject("productList", productList);
        return response;
    }


    @RequestMapping(value = {"/addToInvoice"}, method = RequestMethod.GET)
    public ModelAndView addtocart(@RequestParam(required = false) Integer inventoryId) {
        log.debug("In the addToInvoice controller method.");
        ModelAndView response = new ModelAndView("redirect:/sales/create");

        Inventory inventory = inventoryDAO.findById(inventoryId);

        User user = authenticatedUserService.loadCurrentUser();

        Sales sale = salesDAO.findSaleByStatusAndUserId(user.getId());

        if (sale == null) {

            sale = new Sales();
            sale.setStatus("Cart");
            sale.setUser(user);
            sale.setSaleDate(new Date());
            salesDAO.save(sale);
        }

        SaleDetails saleDetails = saleDetailsDAO.findBySaleIdAndInventoryId(sale.getId(), inventory.getId());

        if (saleDetails == null) {
            saleDetails = new SaleDetails();
            saleDetails.setQuantity(1);
            saleDetails.setInventory(inventory);
            saleDetails.setSales(sale);
            saleDetails.setTotalPrice(inventory.getPrice());
            inventory.setQuantity(inventory.getQuantity() - saleDetails.getQuantity());
        } else {
            saleDetails.setQuantity(saleDetails.getQuantity() + 1);
            saleDetails.setTotalPrice(inventory.getPrice()*saleDetails.getQuantity());
            inventory.setQuantity(inventory.getQuantity() - 1);
        }
        saleDetailsDAO.save(saleDetails);
        inventoryDAO.save(inventory);
        // response.setViewName("redirect:/orders/viewcart");
        return response;
    }

    @RequestMapping(value = {"/submitSale"}, method = RequestMethod.GET)
    public ModelAndView checkout() {
        log.debug("In the submit sale method");

        ModelAndView response = new ModelAndView("redirect:/dashboard");

        User user = authenticatedUserService.loadCurrentUser();

        Sales sale = salesDAO.findSaleByStatusAndUserId(user.getId());
        sale.setStatus("Complete");
        salesDAO.save(sale);

        return response;


    }

    @RequestMapping(value = {"/deleteFromInvoice"}, method = RequestMethod.GET)
    public ModelAndView productSearch(@RequestParam(required = true) Integer inventoryId) {
        log.debug("In the delete from invoice method");


        ModelAndView response = new ModelAndView("redirect:/sales/viewInvoice");

        User user = authenticatedUserService.loadCurrentUser();

        Inventory inventory = inventoryDAO.findById(inventoryId);
        Sales sale = salesDAO.findSaleByStatusAndUserId(user.getId());
        SaleDetails saleDetails = saleDetailsDAO.findBySaleIdAndInventoryId(sale.getId(), inventoryId);

        inventory.setQuantity(inventory.getQuantity() + saleDetails.getQuantity() );
        
        inventoryDAO.save(inventory);
        saleDetailsDAO.deleteFromInvoice(inventoryId);
        response.addObject("inventory", inventory);
        return response;


    }

    @RequestMapping(value = "/saleDetails/{id}", method = RequestMethod.GET)
    public ModelAndView findSaleDetails(@PathVariable Integer id) {
        log.debug("In the saleDetails controller method with search");
        ModelAndView response = new ModelAndView("sales/details");


        List<SaleDetails> saleDetails = new ArrayList<>();
        saleDetails = saleDetailsDAO.findBySaleId(id);

        if (id != null) {
            log.debug("Searching for sales by id = " + id);
            SaleDetails saleDetail = saleDetailsDAO.findById(id);
            if (saleDetail != null) {
                saleDetails.add(saleDetail);
            }
        }

        response.addObject("saleDetailsList", saleDetails);
        //response.addObject("orderId", id);

        return response;
    }
}