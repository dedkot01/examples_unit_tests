package com.example.third_module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.ZoneOffset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Пример тестирования поведения объектов с какой-либо внешней зависимостью
// при помощи "Моков" - объектов с фиктивной реализацией
public class CalendarTest {
    private Calendar spyCalendar;

    @BeforeEach
    public void setUp() {
        Calendar calendar = new Calendar(ZoneOffset.UTC);
        // Объект, созданный как "Мок" считается тем же типом - оригиналом
        // по которому он был создан
        spyCalendar = Mockito.spy(calendar);
    }

    @Test
    public void testGetNameDayOfWeekTodayWhenMonay() {
        // Инструменты тестирования дают возможность заменить реализацию,
        // просто указав, что должен вернуть этот объект при его вызове.
        // В таком случае, сам объект не будет вызываться.
        Mockito.doReturn(0).when(spyCalendar).getDayOfWeekToday();

        String result = spyCalendar.getNameDayOfWeekToday();
        assertEquals("Понедельник", result);
        // Также, у моков можно проверить, был ли этот метод вызван,
        // сколько раз и с какими аргументами
        Mockito.verify(spyCalendar, Mockito.times(1)).getDayOfWeekToday();
    }

    @Test
    public void testGetNameDayOfWeekTodayWhenTuesday() {
        Mockito.doReturn(1).when(spyCalendar).getDayOfWeekToday();

        String result = spyCalendar.getNameDayOfWeekToday();
        assertEquals("Вторник", result);
        Mockito.verify(spyCalendar, Mockito.times(1)).getDayOfWeekToday();
    }

    @Test
    public void testGetNameDayOfWeekTodayWhenInvalidValue() {
        Mockito.doReturn(-1).when(spyCalendar).getDayOfWeekToday();

        // Помимо прочего, инструмены тестирования позволяют проверить блок кода
        // на выброс ожидаемого исключения в определённой ситуации
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> {
                spyCalendar.getNameDayOfWeekToday();
            }
        );
        assertEquals(
            "Несуществующий день недели. Ожидалось число от 0 до 6.",
            exception.getMessage()
        );
        Mockito.verify(spyCalendar, Mockito.times(1)).getDayOfWeekToday();
    }
}
