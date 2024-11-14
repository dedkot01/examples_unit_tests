package com.example.third_module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.ZoneOffset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalendarTest {
    private Calendar spyCalendar;

    @BeforeEach
    public void setUp() {
        Calendar calendar = new Calendar(ZoneOffset.UTC);
        spyCalendar = Mockito.spy(calendar);
    }

    @Test
    public void testShowDayOfWeekTodayWhenMonay() {
        Mockito.doReturn(0).when(spyCalendar).getDayOfWeekToday();

        String result = spyCalendar.showDayOfWeekToday();
        assertEquals("Понедельник", result);
        Mockito.verify(spyCalendar, Mockito.times(1)).getDayOfWeekToday();
    }

    @Test
    public void testShowDayOfWeekTodayWhenTuesday() {
        Mockito.doReturn(1).when(spyCalendar).getDayOfWeekToday();

        String result = spyCalendar.showDayOfWeekToday();
        assertEquals("Вторник", result);
        Mockito.verify(spyCalendar, Mockito.times(1)).getDayOfWeekToday();
    }

    @Test
    public void testShowDayOfWeekTodayWhenInvalidValue() {
        Mockito.doReturn(-1).when(spyCalendar).getDayOfWeekToday();

        IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> {
                spyCalendar.showDayOfWeekToday();
            });
        assertEquals("Несуществующий день недели. Ожидалось число от 0 до 6.", exception.getMessage());
        Mockito.verify(spyCalendar, Mockito.times(1)).getDayOfWeekToday();
    }
}
