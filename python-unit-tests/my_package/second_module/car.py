Position = tuple[int, int]


# Пример тестирования поведения объектов класса
class Car:
    def __init__(self, start_pos_x: int, start_pos_y: int) -> None:
        self.x = start_pos_x
        self.y = start_pos_y

    def get_position(self) -> Position:
        return (self.x, self.y)

    def move(self, velocity_x: int, velocity_y: int) -> None:
        self.x = self.x + velocity_x
        self.y = self.y + velocity_y
