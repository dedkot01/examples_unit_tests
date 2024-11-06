from dataclasses import dataclass


@dataclass
class Item:

    name: str
    quantity: int

    def __init__(self, name: str, quantity: int = 1) -> None:
        if not quantity > 0:
            msg = "Quantity must be positive value."
            raise ValueError(msg)

        self.name = name
        self.quantity = quantity
