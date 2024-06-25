package com.example.weather_app_backend.model;

import java.util.Date;
import java.util.List;

public class Prediccion {
    private String idMunicipio;
    private Date fecha;
    private String prediccion;
    private double temperaturaMedia;
    private String unidadMedidaTemperatura;
    private List<ProbabilidadPrecipitacion> probabilidadPrecipitacion;

    public class ProbabilidadPrecipitacion {
        private String hora;
        private double probabilidad;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(String prediccion) {
        this.prediccion = prediccion;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public String getUnidadMedidaTemperatura() {
        return unidadMedidaTemperatura;
    }

    public void setUnidadMedidaTemperatura(String unidadMedidaTemperatura) {
        this.unidadMedidaTemperatura = unidadMedidaTemperatura;
    }

    public List<ProbabilidadPrecipitacion> getProbabilidadPrecipitacion() {
        return probabilidadPrecipitacion;
    }

    public void setProbabilidadPrecipitacion(List<ProbabilidadPrecipitacion> probabilidadPrecipitacion) {
        this.probabilidadPrecipitacion = probabilidadPrecipitacion;
    }
}