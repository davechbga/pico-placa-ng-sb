package com.pico_placa.pico_placa_backend.model.enums;

import lombok.Getter;

@Getter
public enum RestrictedPlatesEnum {
    MONDAY(new int[]{1, 2}),
    TUESDAY(new int[]{3, 4}),
    WEDNESDAY(new int[]{5, 6}),
    THURSDAY(new int[]{7, 8}),
    FRIDAY(new int[]{9, 0});

    private final int[] restrictedPlates;

    RestrictedPlatesEnum(int[] restrictedPlates) {
        this.restrictedPlates = restrictedPlates;
    }

}
