package com.pico_placa.pico_placa_backend.utils;

import com.pico_placa.pico_placa_backend.model.enums.RestrictedPlatesEnum;
import java.util.Arrays;

public class PlateValidation {

    public static int getLastDigit(String plate) {
        return Integer.parseInt(plate.substring(plate.length() - 1));
    }

    public static boolean isRestrictedDay(int dayOfWeek, int lastDigit) {
        RestrictedPlatesEnum restrictedDay = switch (dayOfWeek) {
            case 1 -> RestrictedPlatesEnum.MONDAY;
            case 2 -> RestrictedPlatesEnum.TUESDAY;
            case 3 -> RestrictedPlatesEnum.WEDNESDAY;
            case 4 -> RestrictedPlatesEnum.THURSDAY;
            case 5 -> RestrictedPlatesEnum.FRIDAY;
            default -> null; // Fines de semana no tienen restricciones
        };

        // Si no hay restricciones (fines de semana), retornamos false
        if (restrictedDay == null) {
            return false;
        }

        // Validamos si el último dígito de la placa está en las restricciones del día
        return Arrays.stream(restrictedDay.getRestrictedPlates()).anyMatch(digit -> digit == lastDigit);
    }
}
