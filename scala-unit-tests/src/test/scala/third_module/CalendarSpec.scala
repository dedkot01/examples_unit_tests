package third_module

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import java.time.ZoneOffset

class CalendarTest extends AnyFlatSpec:
  "A Calendar" should "show day of week today when monday" in:
    val calendarMock = new Calendar(ZoneOffset.UTC):
      override def getDayOfWeekToday(): Int = 0

    assert(calendarMock.showDayOfWeekToday() == "Понедельник")

  it should "show day of week today when tuesday" in:
    val calendarMock = new Calendar(ZoneOffset.UTC):
      override def getDayOfWeekToday(): Int = 1

    assert(calendarMock.showDayOfWeekToday() == "Вторник")

  it should "don't show day of week today when invalid value" in:
    val calendarMock = new Calendar(ZoneOffset.UTC):
      override def getDayOfWeekToday(): Int = -1

    assertThrows[IllegalArgumentException]:
      calendarMock.showDayOfWeekToday()
