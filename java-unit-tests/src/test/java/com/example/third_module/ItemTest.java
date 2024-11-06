package com.example.third_module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ItemTest {
    @Test
    void testNegativeQuantity() {
        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> {
                new Item("Apple", -1);
            });
        assertEquals("Quantity must be positive value.", exception.getMessage());
    }
}
