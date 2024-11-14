package com.example.second_module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Пример тестирования поведения объектов класса,
// проинициализированных в фикстуре
class CarWithFixtureTest {
    private Car car1;

    // Фикстура должна заниматься подготовкой окружения для тестов
    // с заранее известным состоянием,
    // что гарантирует повторяемость процесса тестирования
    @BeforeEach
    void setUp() {
        car1 = new Car(1, 2);
    }

    // При каждом запуске тестов, окружение инициализируется по новой
    @Test
    void testInit() {
        assertEquals(1, car1.x);
        assertEquals(2, car1.y);
    }

    @Test
    void testMove() {
        car1.move(3, 3);
        int[] position = car1.getPosition();

        assertEquals(4, position[0]);
        assertEquals(5, position[1]);
    }

    @Test
    void testGetPosition() {
        int[] position = car1.getPosition();

        assertEquals(1, position[0]);
        assertEquals(2, position[1]);
    }
}
