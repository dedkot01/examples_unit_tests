from unittest.mock import MagicMock, patch

import pytest

from my_package.third_module.item import Item
from my_package.third_module.shop_client import ShopClient


@pytest.fixture
def shop_client1():
    with patch.object(ShopClient, "_ShopClient__send_request_create_order") as mock_send_request_create_order:
        yield ShopClient(host_addr="http://test-server"), mock_send_request_create_order


@pytest.fixture
def item1() -> Item:
    return Item(name="Apple", quantity=2)


@pytest.fixture
def item2() -> Item:
    return Item(name="Banana", quantity=4)


class TestShopClient:

    def test_create_order_with_empty_backet(
        self,
        shop_client1: tuple[ShopClient, MagicMock],
    ):
        client, mock_method = shop_client1
        assert len(client.get_backet()) == 0
        assert client.create_order() is False
        mock_method.assert_not_called()

    def test_create_order_with_not_empty_backet(
        self,
        shop_client1: tuple[ShopClient, MagicMock],
        item1: Item,
        item2: Item,
    ):
        client, mock_method = shop_client1
        mock_method.return_value = True

        client.add_item(item=item1)
        client.add_item(item=item2)

        assert len(client.get_backet()) == 2
        assert client.create_order() is True
        assert len(client.get_backet()) == 0
        mock_method.assert_called_once()
