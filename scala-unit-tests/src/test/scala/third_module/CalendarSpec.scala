package third_module

import org.scalatest.flatspec.AnyFlatSpec
import org.scalamock.scalatest.MockFactory
import java.time.ZoneOffset

class CalendarTest extends AnyFlatSpec with MockFactory:

  trait CalendarFixture:
    val mockCalendarUtils = mock[CalendarUtils]
    val calendar = new Calendar(ZoneOffset.UTC, mockCalendarUtils)

  "A Calendar" should "show day of week today when monday" in new CalendarFixture:
    (mockCalendarUtils.getDayOfWeekToday).expects(*).returns(0).once()
    assert(calendar.showDayOfWeekToday == "Понедельник")

  it should "show day of week today when tuesday" in new CalendarFixture:
    (mockCalendarUtils.getDayOfWeekToday).expects(*).returns(1).once()
    assert(calendar.showDayOfWeekToday == "Вторник")

  it should "don't show day of week today when invalid value" in new CalendarFixture:
    (mockCalendarUtils.getDayOfWeekToday).expects(*).returns(-1).once()
    assertThrows[IllegalArgumentException]:
      calendar.showDayOfWeekToday
