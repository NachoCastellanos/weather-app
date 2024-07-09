package com.example.weather_app_backend.model.prediccion.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstadoCielo {

    @JsonProperty("value")
    private String value;

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("descripcion")
    private String descripcion;

    //Getters and setters
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
