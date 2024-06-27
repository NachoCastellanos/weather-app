package com.example.weather_app_backend.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrediccionDias {
    @JsonProperty("dia")
    private List<PrediccionCadaDia> dia;

    public List<PrediccionCadaDia> getDias() {
        return dia;
    }

    public void setDias(List<PrediccionCadaDia> dia) {
        this.dia = dia;
    }
}