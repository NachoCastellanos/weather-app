package com.example.weather_app_backend.model.prediccion.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PrediccionInput {
    @JsonProperty("origen")
    private Origen origen;

    @JsonProperty("elaborado")
    private String elaborado;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("provincia")
    private String provincia;

    @JsonProperty("prediccion")
    private Prediccion prediccion;

    @JsonProperty("id")
    private String id;

    @JsonProperty("version")
    private String version;

    //Getters and setters
    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
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

    public Prediccion getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(Prediccion prediccion) {
        this.prediccion = prediccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
