package com.example.second_module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void testInit() {
        Car car = new Car(1, 2);

        assertEquals(1, car.x);
        assertEquals(2, car.y);
    }

    @Test
    void testGetPosition() {
        Car car = new Car(1, 2);
        int[] position = car.getPosition();

        assertEquals(1, position[0]);
        assertEquals(2, position[1]);
    }

    @Test
    void testMove() {
        Car car = new Car(1, 2);
        car.move(3, 3);
        int[] position = car.getPosition();

        assertEquals(4, position[0]);
        assertEquals(5, position[1]);
    }
}
