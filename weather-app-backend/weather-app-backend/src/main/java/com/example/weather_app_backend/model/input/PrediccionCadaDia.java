package com.example.weather_app_backend.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrediccionCadaDia {
    @JsonProperty("temperatura")
    private List<PrediccionDetalle> temperatura;

    @JsonProperty("probPrecipitacion")
    private List<PrediccionDetalle> probPrecipitacion;

    public List<PrediccionDetalle> getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(List<PrediccionDetalle> temperatura) {
        this.temperatura = temperatura;
    }

    public List<PrediccionDetalle> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(List<PrediccionDetalle> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }
}