package third_module

import org.scalatest.flatspec.AnyFlatSpec
import org.scalamock.scalatest.MockFactory
import java.time.ZoneOffset

// Пример тестирования поведения объектов с какой-либо внешней зависимостью
// при помощи "Моков" - объектов с фиктивной реализацией
class CalendarTest extends AnyFlatSpec with MockFactory:

  trait CalendarFixture:
    // Объект, созданный как "Мок" считается тем же типом - оригиналом
    // по которому он был создан
    val mockCalendarUtils = mock[CalendarUtils]
    val calendar = new Calendar(ZoneOffset.UTC, mockCalendarUtils)

  "A Calendar" should "get name day of week today when monday" in
    new CalendarFixture:
      // Инструменты тестирования дают возможность заменить реализацию,
      // просто указав, что должен вернуть этот объект при его вызове.
      // В таком случае, сам объект не будет вызываться.
      (mockCalendarUtils.getDayOfWeekToday)
        .expects(*)
        .returns(0)
        // Также, у моков можно проверить, был ли этот метод вызван,
        // сколько раз и с какими аргументами
        .once()
      assert(calendar.getNameDayOfWeekToday == "Понедельник")

  it should "get name day of week today when tuesday" in
    new CalendarFixture:
      (mockCalendarUtils.getDayOfWeekToday).expects(*).returns(1).once()
      assert(calendar.getNameDayOfWeekToday == "Вторник")

  it should "don't get name day of week today when invalid value" in
    new CalendarFixture:
      (mockCalendarUtils.getDayOfWeekToday).expects(*).returns(-1).once()

      // Помимо прочего, инструмены тестирования позволяют проверить блок кода
      // на выброс ожидаемого исключения в определённой ситуации
      assertThrows[IllegalArgumentException]:
        calendar.getNameDayOfWeekToday
