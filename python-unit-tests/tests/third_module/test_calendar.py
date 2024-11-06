from unittest.mock import MagicMock, patch

import pytest

from my_package.third_module.calendar import Calendar


@pytest.fixture
def calendar1_fixture():
    with patch.object(Calendar, "get_day_of_week_today") as mock_get_day_of_week_today_method:
        yield Calendar(time_zone_offset=3), mock_get_day_of_week_today_method


class TestCalendar:

    def test_show_day_of_week_today_when_monday(
        self,
        calendar1_fixture: tuple[Calendar, MagicMock],
    ):
        calendar1, mock_get_day_of_week_today_method = calendar1_fixture
        mock_get_day_of_week_today_method.return_value = 0

        result = calendar1.show_day_of_week_today()

        assert result == "Понедельник"
        mock_get_day_of_week_today_method.assert_called_once()

    def test_show_day_of_week_today_when_tuesday(
        self,
        calendar1_fixture: tuple[Calendar, MagicMock],
    ):
        calendar1, mock_get_day_of_week_today_method = calendar1_fixture
        mock_get_day_of_week_today_method.return_value = 1

        result = calendar1.show_day_of_week_today()

        assert result == "Вторник"
        mock_get_day_of_week_today_method.assert_called_once()

    def test_show_day_of_week_today_when_invalid_value(
        self,
        calendar1_fixture: tuple[Calendar, MagicMock],
    ):
        calendar1, mock_get_day_of_week_today_method = calendar1_fixture
        mock_get_day_of_week_today_method.return_value = -1

        with pytest.raises(ValueError, match="Несуществующий день недели. Ожидалось число от 0 до 6."):
            calendar1.show_day_of_week_today()

        mock_get_day_of_week_today_method.assert_called_once()
