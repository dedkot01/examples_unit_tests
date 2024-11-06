from my_package.second_module.car import Car


class TestCar:

    def test_init(self):
        car = Car(start_pos_x=1, start_pos_y=2)

        assert car.x == 1
        assert car.y == 2

    def test_get_postion(self):
        car = Car(start_pos_x=1, start_pos_y=2)

        assert car.get_position() == (1, 2)

    def test_move(self):
        car = Car(start_pos_x=1, start_pos_y=2)
        car.move(velocity_x=3, velocity_y=3)

        assert car.get_position() == (4, 5)
