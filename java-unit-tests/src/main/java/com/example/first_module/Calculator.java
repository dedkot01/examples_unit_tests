package com.example.first_module;

// Самые простые функции для демонстрации базового функционала Unit тестов
public class Calculator {
    public static int add(int x, int y) {
        return x + y;
    }

    public static int sub(int x, int y) {
        return x - y;
    }

    public static int mul_by_2(int x) {
        // Случай, который должен быть выявлен в результате прохождения тестов
        return x * 3;
    }
}
