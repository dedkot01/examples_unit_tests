from datetime import datetime, timedelta, timezone


# Пример тестирования объектов с внешней зависимостью
class Calendar:
    def __init__(self, time_zone_offset: int) -> None:
        self.__time_zone_offset = time_zone_offset

    # Возвращаемое значение зависит от времени запуска функции
    def get_day_of_week_today(self) -> int:
        return datetime.now(
            tz=timezone(timedelta(hours=self.__time_zone_offset)),
        ).weekday()

    def get_name_day_of_week_today(self) -> str:
        days_of_week = {
            0: "Понедельник",
            1: "Вторник",
            2: "Среда",
            3: "Четверг",
            4: "Пятница",
            5: "Суббота",
            6: "Воскресенье",
        }
        day = self.get_day_of_week_today()

        if 0 <= day <= 6:
            return days_of_week.get(day)
        msg = "Несуществующий день недели. Ожидалось число от 0 до 6."
        raise ValueError(msg)
