package com.example.weather_app_backend.model.clima;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Medicion {
    @JsonProperty("value")
    private String value;

    @JsonProperty("periodo")
    private String periodo;

    // getters and setters

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
}