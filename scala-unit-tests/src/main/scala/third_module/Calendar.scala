package third_module

import java.time.LocalDate
import java.time.ZoneOffset


class Calendar(val timeZoneOffset: ZoneOffset, calendarUtils: CalendarUtils):

  def showDayOfWeekToday: String =
    calendarUtils.getDayOfWeekToday(timeZoneOffset) match
      case 0 => "Понедельник"
      case 1 => "Вторник"
      case 2 => "Среда"
      case 3 => "Четверг"
      case 4 => "Пятница"
      case 5 => "Суббота"
      case 6 => "Воскресенье"
      case _ => throw new IllegalArgumentException("Несуществующий день недели. Ожидалось число от 0 до 6.")
