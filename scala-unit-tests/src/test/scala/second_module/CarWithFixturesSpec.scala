package second_module

import org.scalatest.flatspec.AnyFlatSpec

// Пример тестирования поведения объектов класса,
// проинициализированных в фикстуре
class CarWithFixturesSpec extends AnyFlatSpec:
  // Фикстура должна заниматься подготовкой окружения для тестов
  // с заранее известным состоянием,
  // что гарантирует повторяемость процесса тестирования
  trait CarFixture:
    val car = new Car(x = 1, y = 2)

  // При каждом запуске тестов, окружение инициализируется по новой
  "A Car" should "start from start position" in new CarFixture:
    assert(car.x == 1)
    assert(car.y == 2)

  it should "move" in new CarFixture:
    car.move(velocity_x = 3, velocity_y = 3)
    assert(car.get_position == (4, 5))

  it should "return current position" in new CarFixture:
    assert(car.get_position == (1, 2))
