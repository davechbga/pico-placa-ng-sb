package com.pico_placa.pico_placa_backend.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TimeValidation {

    public static LocalDateTime parseDateTime(String date, String hour) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(date + " " + hour, formatter);
    }

    public static boolean isValidFutureDate(LocalDateTime dateTime) {
        return !dateTime.isBefore(LocalDateTime.now(ZoneId.of("America/Guayaquil")));
    }

    public static boolean isWeekendOrHoliday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek().getValue() >= 6; // 6 = sábado, 7 = domingo
    }

    public static boolean isWithinRestrictedHours(LocalTime time) {
        return (time.isAfter(LocalTime.of(6, 0)) && time.isBefore(LocalTime.of(9, 30)))
                || (time.isAfter(LocalTime.of(16, 0)) && time.isBefore(LocalTime.of(20, 0)));
    }
}
