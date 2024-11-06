package first_module

import org.scalatest.flatspec.AnyFlatSpec


class BasicCalcFuncSpec extends AnyFlatSpec:
  "The add func" should "sum" in:
    assert(add(1, 2) == 3)
    assert(add(0, 0) == 0)
    assert(add(1, -2) == -1)

  "The sub func" should "substract" in:
    assert(sub(1, 2) == -1)
    assert(sub(0, 0) == 0)
    assert(sub(1, -2) == 3)

  "The mul_by_2 func" should "multiply by 2" in:
    assert(mul_by_2(0) == 0)
    assert(mul_by_2(2) == 4)
    assert(mul_by_2(-1) == -2)