package com.example.third_module;

import java.time.LocalDate;
import java.time.ZoneOffset;

public class Calendar {
    private ZoneOffset zoneOffset;

    public Calendar(ZoneOffset timeZoneOffset) {
        this.zoneOffset = timeZoneOffset;
    }

    public int getDayOfWeekToday() {
        return LocalDate.now(zoneOffset).getDayOfWeek().getValue();
    }

    public String showDayOfWeekToday() {
        switch (getDayOfWeekToday()) {
            case 0:
                return "Понедельник";
            case 1:
                return "Вторник";
            case 2:
                return "Среда";
            case 3:
                return "Четверг";
            case 4:
                return "Пятница";
            case 5:
                return "Суббота";
            case 6:
                return "Воскресенье";
            default:
                throw new IllegalArgumentException("Несуществующий день недели. Ожидалось число от 0 до 6.");
        }
    }
}