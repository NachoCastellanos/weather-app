package com.example.weather_app_backend.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PrediccionMunicipio {
    @JsonProperty("origen")
    private Map<String, Object> origen;

    @JsonProperty("elaborado")
    private String elaborado;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("provincia")
    private String provincia;

    @JsonProperty("prediccion")
    private PrediccionDias prediccionDias;

    //getters and setters

    public Map<String, Object> getOrigen() {
        return origen;
    }

    public void setOrigen(Map<String, Object> origen) {
        this.origen = origen;
    }

    public String getElaborado() {
        return elaborado;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public PrediccionDias getPrediccionDias() {
        return prediccionDias;
    }

    public void getPrediccionDias(PrediccionDias prediccionDias) {
        this.prediccionDias = prediccionDias;
    }
}