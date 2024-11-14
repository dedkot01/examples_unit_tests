package first_module

import org.scalatest.flatspec.AnyFlatSpec

// Тесты располагаются в том же пространстве, что и тестируемый модуль
class BasicCalcFuncSpec extends AnyFlatSpec:
  "The add func" should "sum" in:
    // Assert проверяет, что условие внутри истинно
    assert(add(1, 2) == 3)
    assert(add(0, 0) == 0)
    assert(add(1, -2) == -1)

  "The sub func" should "substract" in:
    assert(sub(1, 2) == -1)
    assert(sub(0, 0) == 0)
    assert(sub(1, -2) == 3)

  "The mul_by_2 func" should "multiply by 2" in:
    assert(mul_by_2(0) == 0)
    // Если условие будет ложным - тест провален,
    // что можно будет наблюдать в отчёте
    assert(mul_by_2(2) == 4)
    assert(mul_by_2(-1) == -2)
