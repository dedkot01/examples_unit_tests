import pytest

from my_package.third_module.item import Item


class TestItem:

    def test_negative_quantity(self):
        with pytest.raises(ValueError, match="Quantity must be positive value."):
            Item(
                name="Apple",
                quantity=-1,
            )
