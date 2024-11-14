import pytest

from my_package.second_module.car import Car


# Фикстура должна заниматься подготовкой окружения для тестов
# с заранее известным состоянием,
# что гарантирует повторяемость процесса тестирования
@pytest.fixture
def car1() -> Car:
    return Car(start_pos_x=1, start_pos_y=2)


# Пример тестирования поведения объектов класса,
# проинициализированных в фикстуре
class TestCarWithFixture:
    # При каждом запуске тестов, окружение инициализируется по новой
    def test_init(self, car1: Car):
        assert car1.x == 1
        assert car1.y == 2

    def test_get_postion(self, car1: Car):
        assert car1.get_position() == (1, 2)

    def test_move(self, car1: Car):
        car1.move(velocity_x=3, velocity_y=3)

        assert car1.get_position() == (4, 5)
