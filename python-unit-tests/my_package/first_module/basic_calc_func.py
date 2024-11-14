# Самые простые функции для демонстрации базового функционала Unit тестов
def add(x: int, y: int) -> int:
    return x + y


def sub(x: int, y: int) -> int:
    return x - y


def mul_by_2(x: int) -> int:
    # Случай, который должен быть выявлен в результате прохождения тестов
    return x * 3
