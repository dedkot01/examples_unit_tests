package com.example.second_module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Пример тестирования поведения объектов класса
class CarTest {
    @Test
    void testInit() {
        // Каждый тест необходимо инициализировать объект класса,
        // что является повторением кода.
        Car car = new Car(1, 2);

        assertEquals(1, car.x);
        assertEquals(2, car.y);
    }

    @Test
    void testMove() {
        // Если вынести инициализацию объектов до запуска тестов,
        // то один и тот же объект будет проходить все тесты,
        // в рамках которых его внутренее состояние может меняться.
        // Поэтому, его необходимо инициализировать каждый раз.
        Car car = new Car(1, 2);
        car.move(3, 3);
        int[] position = car.getPosition();

        assertEquals(4, position[0]);
        assertEquals(5, position[1]);
    }

    @Test
    void testGetPosition() {
        // Однако, существует приём "Фикстура", благодаря которому,
        // можно переиспользовать код инициализации объектов
        // в нескольких тестах.
        Car car = new Car(1, 2);
        int[] position = car.getPosition();

        assertEquals(1, position[0]);
        assertEquals(2, position[1]);
    }
}
