package third_module

import java.time.LocalDate
import java.time.ZoneOffset

class CalendarUtils:
  // Возвращаемое значение зависит от времени запуска функции
  def getDayOfWeekToday(timeZoneOffset: ZoneOffset): Int =
    LocalDate.now(timeZoneOffset).getDayOfWeek().getValue()
