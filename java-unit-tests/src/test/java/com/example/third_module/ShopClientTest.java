package com.example.third_module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopClientTest {
    private ShopClient shopClient1;
    private Item item1;
    private Item item2;

    @BeforeEach
    void setUp() {
        shopClient1 = new ShopClient("http://test-server");
        item1 = new Item("Apple", 2);
        item2 = new Item("Banana", 4);
    }

    @Test
    void testCreateOrderWithEmptyBacket() {
        assertEquals(0, shopClient1.getBacket().size());
        assertEquals(false, shopClient1.createOrder());
    }

    @Test
    void testCreateOrderWithNotEmptyBacket() {
        shopClient1.addItem(item1);
        shopClient1.addItem(item2);

        assertEquals(2, shopClient1.getBacket().size());
        assertEquals(true, shopClient1.createOrder());
        assertEquals(0, shopClient1.getBacket().size());
    }
}
