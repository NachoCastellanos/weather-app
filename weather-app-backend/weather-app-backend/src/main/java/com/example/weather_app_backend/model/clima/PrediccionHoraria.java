package com.example.weather_app_backend.model.clima;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrediccionHoraria {
    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("temperatura")
    private Temperatura temperatura;

    @JsonProperty("probPrecipitacion")
    private List<ProbabilidadPrecipitacion> probPrecipitacion;

    // getters and setters

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    public List<ProbabilidadPrecipitacion> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(List<ProbabilidadPrecipitacion> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }
}