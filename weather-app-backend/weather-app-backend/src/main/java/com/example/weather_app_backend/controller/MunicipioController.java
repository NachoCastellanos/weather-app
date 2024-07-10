package com.example.weather_app_backend.controller;

import com.example.weather_app_backend.model.municipios.Municipio;
import com.example.weather_app_backend.model.prediccion.input.PrediccionInput;
import com.example.weather_app_backend.model.prediccion.output.PrediccionOutput;
import com.example.weather_app_backend.service.AemetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MunicipioController {
    @Autowired
    private AemetService aemetService;

    public MunicipioController(AemetService aemetService) {
        this.aemetService = aemetService;
    }

    @GetMapping("/")
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/municipios")
    public List<String> getMunicipios() {
        List<Municipio> municipios = aemetService.getAllMunicipios();
        return municipios.stream()
                .map(Municipio::getCapital)
                .collect(Collectors.toList());
    }

    /*
    @GetMapping("/prediccion/{idMunicipio}")
    public PrediccionInput[] getPrediccion(@PathVariable String idMunicipio) {
        return aemetService.getPrediccionMunicipio(idMunicipio);
    }
    */

    @GetMapping("/prediccion/{idMunicipio}")
    public List<PrediccionOutput> getPrediccion(@PathVariable String idMunicipio) {
        List<PrediccionOutput> predidcionMunicipio = aemetService.getPrediccionMunicipio(idMunicipio);
        return predidcionMunicipio;
    }

}



