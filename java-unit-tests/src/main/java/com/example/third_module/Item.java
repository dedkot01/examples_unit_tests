package com.example.third_module;

public class Item {
    String name;
    private int quantity;

    public Item(String name) {
        this(name, 1);
    }

    public Item(String name, int quantity) {
        this.name = name;
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (!(quantity > 0)) {
            throw new IllegalArgumentException("Quantity must be positive value.");
        }
        this.quantity = quantity;
    }

    public String toJson() {
        return "asd";
    }
}
