package com.example.weather_app_backend.controller;

import com.example.weather_app_backend.model.Municipio;
import com.example.weather_app_backend.model.Prediccion;
import com.example.weather_app_backend.service.AemetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MunicipioController {

    private AemetService aemetService;

    public MunicipioController(AemetService aemetService) {
        this.aemetService = aemetService;
    }

    @GetMapping("/municipios")
    public List<String> getMunicipios() {
        List<Municipio> municipios = aemetService.getAllMunicipios();
        return municipios.stream()
                .map(Municipio::getCapital)
                .collect(Collectors.toList());
    }

    @GetMapping("/")
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/prediccion/{codigoMunicipio}")
    public Prediccion getPrediccion(@PathVariable String codigoMunicipio) {
        return aemetService.getPrediccion(codigoMunicipio, "G_CEL");
    }
}



