package second_module

import org.scalatest.flatspec.AnyFlatSpec

// Пример тестирования поведения объектов класса
class CarSpec extends AnyFlatSpec:
  "A Car" should "start from start position" in:
    // Каждый тест необходимо инициализировать объект класса,
    // что является повторением кода.
    val car = Car(x = 1, y = 2)

    assert(car.x == 1)
    assert(car.y == 2)

  it should "move" in:
    // Если вынести инициализацию объектов до запуска тестов,
    // то один и тот же объект будет проходить все тесты,
    // в рамках которых его внутренее состояние может меняться.
    // Поэтому, его необходимо инициализировать каждый раз.
    val car = Car(x = 1, y = 2)
    car.move(velocity_x = 3, velocity_y = 3)

    assert(car.get_position == (4, 5))

  it should "return current position" in:
    // Однако, существует приём "Фикстура", благодаря которому,
    // можно переиспользовать код инициализации объектов в нескольких тестах.
    val car = Car(x = 1, y = 2)
    assert(car.get_position == (1, 2))
