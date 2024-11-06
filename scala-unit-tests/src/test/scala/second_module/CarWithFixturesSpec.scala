package second_module

import org.scalatest.flatspec.AnyFlatSpec


class CarWithFixturesSpec extends AnyFlatSpec:

  trait CarFixture:
    val car = new Car(x = 1, y = 2)

  "A Car" should "start from start position" in new CarFixture:
    assert(car.x == 1)
    assert(car.y == 2)

  it should "move" in new CarFixture:
    car.move(velocity_x = 3, velocity_y = 3)

    assert(car.get_position == (4, 5))

  it should "return current position" in new CarFixture:
    assert(car.get_position == (1, 2))
