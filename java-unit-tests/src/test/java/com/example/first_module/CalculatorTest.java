package com.example.first_module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Тесты располагаются в том же пространстве, что и тестируемый модуль
class CalculatorTest {
    @Test
    void testAdd() {
        // Assert проверяет, что действительно значение совпадает с ожидаемым
        assertEquals(3, Calculator.add(1, 2));
        assertEquals(0, Calculator.add(0, 0));
        assertEquals(-1, Calculator.add(1, -2));
    }

    @Test
    void testSub() {
        assertEquals(-1, Calculator.sub(1, 2));
        assertEquals(0, Calculator.sub(0, 0));
        assertEquals(3, Calculator.sub(1, -2));
    }

    @Test
    void testMulBy2() {
        assertEquals(0, Calculator.mul_by_2(0));
        // Если условие будет ложным - тест провален,
        // что можно будет наблюдать в отчёте
        assertEquals(4, Calculator.mul_by_2(2));
        assertEquals(-2, Calculator.mul_by_2(-1));
    }
}
