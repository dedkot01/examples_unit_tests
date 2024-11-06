import requests

from my_package.third_module.item import Item


class ShopClient:

    def __init__(
        self,
        host_addr: str = "http://localhost:8080",
    ) -> None:
        self.__host_addr = host_addr
        self.__backet: list[Item] = []

    def get_backet(self) -> list[Item]:
        return self.__backet

    def add_item(self, item: Item) -> None:
        self.__backet.append(item)

    def remove_item(self, item: Item) -> None:
        self.__backet.remove(item)

    def clear_backet(self) -> None:
        self.__backet.clear()

    def create_order(self) -> bool:
        if len(self.__backet) == 0:
            return False

        if (result := self.__send_request_create_order()) is True:
            self.clear_backet()

        return result

    def __send_request_create_order(self) -> bool:
        response = requests.post(
            url=f"{self.__host_addr}/api/order",
            json={
                "items": [item.__dict__ for item in self.__backet],
            },
        )

        return (response.status_code / 100) == 2
