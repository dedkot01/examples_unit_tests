package third_module

import java.time.LocalDate
import java.time.ZoneOffset


class CalendarUtils:

  def getDayOfWeekToday(timeZoneOffset: ZoneOffset): Int =
    LocalDate.now(timeZoneOffset).getDayOfWeek().getValue()
