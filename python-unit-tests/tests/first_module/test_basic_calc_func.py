from my_package.first_module.basic_calc_func import add, mul_by_2, sub


# Тесты располагаются в том же пространстве, что и тестируемый модуль
class TestBasicCalcFunc:
    def test_add(self) -> None:
        # Assert проверяет, что условие внутри истинно
        assert add(1, 2) == 3
        assert add(0, 0) == 0
        assert add(1, -2) == -1

    def test_sub(self) -> None:
        assert sub(1, 2) == -1
        assert sub(0, 0) == 0
        assert sub(1, -2) == 3

    def test_mul_by_2(self) -> None:
        assert mul_by_2(0) == 0
        # Если условие будет ложным - тест провален,
        # что можно будет наблюдать в отчёте
        assert mul_by_2(2) == 4
        assert mul_by_2(-1) == -2
