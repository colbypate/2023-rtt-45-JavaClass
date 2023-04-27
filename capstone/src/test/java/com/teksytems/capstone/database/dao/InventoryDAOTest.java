package com.teksytems.capstone.database.dao;

import com.teksytems.capstone.database.dao.InventoryDAO;
import com.teksytems.capstone.database.entity.Inventory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.data.jpa.repository.Query;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InventoryDAOTest {

    @Autowired
    private InventoryDAO inventoryDAO;

    @Test
    public void findById() {
        inventoryDAO.findById(4);
    }

    @Test
    @Order(0)
    public void createInventory() {

        Inventory given = new Inventory();
        given.setProductName("test");
        given.setQuantity(5);
        given.setPrice(1.99);
        given.setPhotoURL(null);
        inventoryDAO.save(given);

        Inventory actual = inventoryDAO.findInventoryByProductNameExact("test");

        Assertions.assertEquals(given.getProductName(), actual.getProductName());
        Assertions.assertEquals(given.getPrice(), actual.getPrice());
        Assertions.assertEquals(given.getQuantity(), actual.getQuantity());
        Assertions.assertEquals(given.getPhotoURL(), actual.getPhotoURL());


    }

}
