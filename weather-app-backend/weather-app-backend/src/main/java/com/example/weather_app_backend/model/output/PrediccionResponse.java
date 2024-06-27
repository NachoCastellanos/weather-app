package com.example.weather_app_backend.model.output;

import java.util.List;

public class PrediccionResponse {
    private double mediaTemperatura;
    private List<ProbPrecipitacion> probPrecipitacion;

    // getters and setters
    public double getMediaTemperatura() {
        return mediaTemperatura;
    }

    public void setMediaTemperatura(double mediaTemperatura) {
        this.mediaTemperatura = mediaTemperatura;
    }

    public List<ProbPrecipitacion> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(List<ProbPrecipitacion> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }
}