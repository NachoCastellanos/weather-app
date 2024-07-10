package com.example.weather_app_backend.model.prediccion.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Prediccion {
    @JsonProperty("dia")
    private List<Dia> dia;

    //Getters and setters

    public List<Dia> getDia() {
        return dia;
    }

    public void setDia(List<Dia> dia) {
        this.dia = dia;
    }
}