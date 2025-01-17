package com.pico_placa.pico_placa_backend.controller;


import com.pico_placa.pico_placa_backend.model.dto.VehicleRequestDTO;
import com.pico_placa.pico_placa_backend.model.dto.VehicleResponseDTO;
import com.pico_placa.pico_placa_backend.service.PlateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlateController {

    private final PlateService plateService;

    @Autowired
    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @PostMapping("/validate")
    public ResponseEntity<VehicleResponseDTO> validate(@RequestBody @Valid VehicleRequestDTO vehicleRequestDTO) {
        // Llamar al servicio para validar el vehículo
        String responseMessage = plateService.validatePlate(vehicleRequestDTO.getPlate(),
                vehicleRequestDTO.getDate(),
                vehicleRequestDTO.getHour());

        // Retornar la respuesta como un DTO
        return ResponseEntity.ok(new VehicleResponseDTO(responseMessage));
    }
}
