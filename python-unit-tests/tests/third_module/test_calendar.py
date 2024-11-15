from unittest.mock import MagicMock, patch

import pytest

from my_package.third_module.calendar import Calendar


@pytest.fixture
def calendar1_fixture():
    # Объект, созданный как "Мок" считается тем же типом - оригиналом
    # по которому он был создан
    with patch.object(
        Calendar,
        "get_day_of_week_today",
    ) as mock_get_day_of_week_today_method:
        yield Calendar(time_zone_offset=3), mock_get_day_of_week_today_method


# Пример тестирования поведения объектов с какой-либо внешней зависимостью
# при помощи "Моков" - объектов с фиктивной реализацией
class TestCalendar:
    def test_get_name_day_of_week_today_when_monday(
        self,
        calendar1_fixture: tuple[Calendar, MagicMock],
    ):
        calendar1, mock_get_day_of_week_today_method = calendar1_fixture
        # Инструменты тестирования дают возможность заменить реализацию,
        # просто указав, что должен вернуть этот объект при его вызове.
        # В таком случае, сам объект не будет вызываться.
        mock_get_day_of_week_today_method.return_value = 0

        result = calendar1.get_name_day_of_week_today()

        assert result == "Понедельник"
        # Также, у моков можно проверить, был ли этот метод вызван,
        # сколько раз и с какими аргументами
        mock_get_day_of_week_today_method.assert_called_once()

    def test_get_name_day_of_week_today_when_tuesday(
        self,
        calendar1_fixture: tuple[Calendar, MagicMock],
    ):
        calendar1, mock_get_day_of_week_today_method = calendar1_fixture
        mock_get_day_of_week_today_method.return_value = 1

        result = calendar1.get_name_day_of_week_today()

        assert result == "Вторник"
        mock_get_day_of_week_today_method.assert_called_once()

    def test_get_name_day_of_week_today_when_invalid_value(
        self,
        calendar1_fixture: tuple[Calendar, MagicMock],
    ):
        calendar1, mock_get_day_of_week_today_method = calendar1_fixture
        mock_get_day_of_week_today_method.return_value = -1

        # Помимо прочего, инструмены тестирования позволяют проверить блок кода
        # на выброс ожидаемого исключения в определённой ситуации
        with pytest.raises(
            ValueError,
            match="Несуществующий день недели. Ожидалось число от 0 до 6.",
        ):
            calendar1.get_name_day_of_week_today()

        mock_get_day_of_week_today_method.assert_called_once()
