package com.pico_placa.pico_placa_backend.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponseDTO {

    // Respuesta del servicio
    private String response;

    // Constructor
    public VehicleResponseDTO(String response) {
        this.response = response;
    }
}
