package third_module

import org.scalatest.flatspec.AnyFlatSpec


class ItemSpec extends AnyFlatSpec:

  "A Item" should "quantity is positive" in:
    assertThrows[IllegalArgumentException]:
      Item(name = "Apple", quantity = -1)
