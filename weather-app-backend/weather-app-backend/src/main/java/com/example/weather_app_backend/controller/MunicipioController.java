package com.example.weather_app_backend.controller;

import com.example.weather_app_backend.model.Municipio;
import com.example.weather_app_backend.service.AemetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MunicipioController {

    private AemetService aemetService;

    public MunicipioController(AemetService aemetService) {
        this.aemetService = aemetService;
    }

    @GetMapping("/municipios")
    public List<Municipio> getMunicipios() {
        return aemetService.getAllMunicipios();
    }
}



