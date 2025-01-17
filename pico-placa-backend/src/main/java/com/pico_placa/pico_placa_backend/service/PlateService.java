package com.pico_placa.pico_placa_backend.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.pico_placa.pico_placa_backend.utils.PlateValidation.getLastDigit;
import static com.pico_placa.pico_placa_backend.utils.PlateValidation.isRestrictedDay;
import static com.pico_placa.pico_placa_backend.utils.TimeValidation.*;

@Service
public class PlateService {

    public String validatePlate(String plate, String date, String hour) {
        LocalDateTime inputDateTime = parseDateTime(date, hour);

        if (!isValidFutureDate(inputDateTime)) {
            return "La fecha y hora ingresada no puede ser anterior a la actual.";
        }

        int lastDigit = getLastDigit(plate);

        if (isWeekendOrHoliday(inputDateTime)) {
            return "El vehículo puede circular.";
        }

        if (isWithinRestrictedHours(inputDateTime.toLocalTime())
                && isRestrictedDay(inputDateTime.getDayOfWeek().getValue(), lastDigit)) {
            return "El vehículo no puede circular.";
        }

        return "El vehículo puede circular.";
    }
}
