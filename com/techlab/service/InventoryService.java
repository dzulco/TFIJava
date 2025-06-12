package com.techlab.service;

import com.techlab.model.Inventory;

import java.util.ArrayList;

public class InventoryService {

    Inventory inventory;

    public InventoryService() {
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
