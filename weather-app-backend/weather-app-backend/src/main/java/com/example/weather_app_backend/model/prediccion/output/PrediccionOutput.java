package com.example.weather_app_backend.model.prediccion.output;

import com.example.weather_app_backend.model.prediccion.input.PrediccionDetalle;

import java.util.List;

public class PrediccionOutput {
    private double mediaTemperatura;
    private List<PrediccionDetalle> probPrecipitacion;

    public PrediccionOutput(double mediaTemperatura, List<PrediccionDetalle> probPrecipitacion) {
        this.mediaTemperatura = mediaTemperatura;
        this.probPrecipitacion = probPrecipitacion;
    }

    // Getters y setters
    public double getMediaTemperatura() {
        return mediaTemperatura;
    }

    public void setMediaTemperatura(double mediaTemperatura) {
        this.mediaTemperatura = mediaTemperatura;
    }

    public List<PrediccionDetalle> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(List<PrediccionDetalle> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }
}
