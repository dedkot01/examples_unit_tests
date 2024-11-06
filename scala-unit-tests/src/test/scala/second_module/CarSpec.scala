package second_module

import org.scalatest.flatspec.AnyFlatSpec


class CarSpec extends AnyFlatSpec:
  "A Car" should "start from start position" in:
    val car = Car(x = 1, y = 2)

    assert(car.x == 1)
    assert(car.y == 2)

  it should "return current position" in:
    val car = Car(x = 1, y = 2)

    assert(car.get_position == (1, 2))

  it should "move" in:
    val car = Car(x = 1, y = 2)
    car.move(velocity_x = 3, velocity_y = 3)

    assert(car.get_position == (4, 5))
