package com.example.weather_app_backend.model.output;

public class ProbPrecipitacion {
    private int probabilidad;
    private String fecha;

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String periodo) {
        this.fecha = fecha;
    }
}