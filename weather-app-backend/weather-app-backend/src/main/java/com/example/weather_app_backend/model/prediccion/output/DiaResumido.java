package com.example.weather_app_backend.model.prediccion.output;

import com.example.weather_app_backend.model.prediccion.input.PrediccionDetalle;

import java.util.List;

public class DiaResumido {
    private List<PrediccionDetalle> temperatura;
    private List<PrediccionDetalle> probPrecipitacion;
    public DiaResumido(List<PrediccionDetalle> temperatura, List<PrediccionDetalle> probPrecipitacion) {
        this.temperatura = temperatura;
        this.probPrecipitacion = probPrecipitacion;
    }

    // Getters y setters
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