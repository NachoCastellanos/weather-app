package com.example.weather_app_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Municipio {
    @JsonProperty("latitud")
    private String latitud;
    @JsonProperty("id_old")
    private String idOld;
    @JsonProperty("url")
    private String url;
    @JsonProperty("latitud_dec")
    private String latitudDec;
    @JsonProperty("altitud")
    private String altitud;
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("num_hab")
    private String numHab;
    @JsonProperty("zona_comarcal")
    private String zonaComarcal;
    @JsonProperty("destacada")
    private String destacada;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("longitud_dec")
    private String longitudDec;
    @JsonProperty("id")
    private String id;
    @JsonProperty("longitud")
    private String longitud;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getIdOld() {
        return idOld;
    }

    public void setIdOld(String idOld) {
        this.idOld = idOld;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLatitudDec() {
        return latitudDec;
    }

    public void setLatitudDec(String latitudDec) {
        this.latitudDec = latitudDec;
    }

    public String getAltitud() {
        return altitud;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNumHab() {
        return numHab;
    }

    public void setNumHab(String numHab) {
        this.numHab = numHab;
    }

    public String getZonaComarcal() {
        return zonaComarcal;
    }

    public void setZonaComarcal(String zonaComarcal) {
        this.zonaComarcal = zonaComarcal;
    }

    public String getDestacada() {
        return destacada;
    }

    public void setDestacada(String destacada) {
        this.destacada = destacada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLongitudDec() {
        return longitudDec;
    }

    public void setLongitudDec(String longitudDec) {
        this.longitudDec = longitudDec;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
