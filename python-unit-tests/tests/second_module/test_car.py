from my_package.second_module.car import Car


# Пример тестирования поведения объектов класса
class TestCar:
    def test_init(self):
        # Каждый тест необходимо инициализировать объект класса,
        # что является повторением кода.
        car = Car(start_pos_x=1, start_pos_y=2)

        assert car.x == 1
        assert car.y == 2

    def test_move(self):
        # Если вынести инициализацию объектов до запуска тестов,
        # то один и тот же объект будет проходить все тесты,
        # в рамках которых его внутренее состояние может меняться.
        # Поэтому, его необходимо инициализировать каждый раз.
        car = Car(start_pos_x=1, start_pos_y=2)
        car.move(velocity_x=3, velocity_y=3)

        assert car.get_position() == (4, 5)

    def test_get_postion(self):
        # Однако, существует приём "Фикстура", благодаря которому,
        # можно переиспользовать код инициализации объектов
        # в нескольких тестах.
        car = Car(start_pos_x=1, start_pos_y=2)
        assert car.get_position() == (1, 2)
