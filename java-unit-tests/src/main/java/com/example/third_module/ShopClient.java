package com.example.third_module;

import java.util.ArrayList;

public class ShopClient {
    String hostAddr;
    private ArrayList<Item> backet;

    public ShopClient() {
        this("http://localhost:8080");
    }

    public ShopClient(String hostAddr) {
        this.hostAddr = hostAddr;
        backet = new ArrayList<>();
    }

    public ArrayList<Item> getBacket() {
        return backet;
    }

    public void addItem(Item item) {
        backet.add(item);
    }

    public void removeItem(Item item) {
        backet.remove(item);
    }

    public void clearBacket() {
        backet.clear();
    }

    public boolean createOrder() {
        if (backet.isEmpty()) {
            return false;
        }

        boolean result = true;
        if (result) {
            clearBacket();
        }
        
        return result;
    }
}
