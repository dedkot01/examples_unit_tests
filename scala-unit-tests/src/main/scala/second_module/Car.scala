package second_module

// Пример тестирования поведения объектов класса
class Car(var x: Int, var y: Int):
  def get_position = (x, y)

  def move(velocity_x: Int, velocity_y: Int) =
    x += velocity_x
    y += velocity_y
