package com.pico_placa.pico_placa_backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VehicleRequestDTO {

    // Validación de la placa, debe ser no vacío y con un formato específico
    @NotBlank(message = "La placa no puede estar vacía.")
    @Pattern(regexp = "^[A-Z]{3}-\\d{4}$", message = "La placa debe estar en el formato ABC-1234.")
    private String plate;

    // Validación de la fecha, debe estar en el formato correcto
    @NotBlank(message = "La fecha no puede estar vacía.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe estar en el formato yyyy-MM-dd.")
    private String date;

    // Validación de la hora, debe estar en el formato correcto
    @NotBlank(message = "La hora no puede estar vacía.")
    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "La hora debe estar en el formato HH:mm.")
    private String hour;

}
