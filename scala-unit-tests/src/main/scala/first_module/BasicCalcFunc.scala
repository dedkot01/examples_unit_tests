package first_module

// Самые простые функции для демонстрации базового функционала Unit тестов
def add(x: Int, y: Int): Int = x + y

def sub(x: Int, y: Int): Int = x - y

def mul_by_2(x: Int): Int =
  // Случай, который должен быть выявлен в результате прохождения тестов
  x * 3
