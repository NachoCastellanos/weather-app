package com.example.weather_app_backend.model.prediccion.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public class VientoAndRachaMax {

    @JsonProperty("direccion")
    private List<String> direccion;

    @JsonProperty("velocidad")
    private List<String> velocidad;

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("value")
    private String value;

    // Getters and setters
    public List<String> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<String> direccion) {
        this.direccion = direccion;
    }

    public List<String> getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(List<String> velocidad) {
        this.velocidad = velocidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Optional<String> getValue() {
        return Optional.ofNullable(value);
    }

    public void setValue(String value) {
        this.value = value;
    }
}