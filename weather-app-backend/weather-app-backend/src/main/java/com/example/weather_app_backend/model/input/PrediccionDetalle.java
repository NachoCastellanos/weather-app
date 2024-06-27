package com.example.weather_app_backend.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrediccionDetalle {
    @JsonProperty("value")
    private String value;

    @JsonProperty("periodo")
    private String fecha;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}