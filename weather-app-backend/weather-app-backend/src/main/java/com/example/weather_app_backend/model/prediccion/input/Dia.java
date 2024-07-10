package com.example.weather_app_backend.model.prediccion.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dia {

    @JsonProperty("estadoCielo")
    private List<EstadoCielo> estadoCielo;

    @JsonProperty("precipitacion")
    private List<PrediccionDetalle> precipitacion;

    @JsonProperty("probPrecipitacion")
    private List<PrediccionDetalle> probPrecipitacion;

    @JsonProperty("probTormenta")
    private List<PrediccionDetalle> probTormenta;

    @JsonProperty("nieve")
    private List<PrediccionDetalle> nieve;

    @JsonProperty("probNieve")
    private List<PrediccionDetalle> probNieve;

    @JsonProperty("temperatura")
    private List<PrediccionDetalle> temperatura;
    @JsonProperty("sensTermica")
    private List<PrediccionDetalle> sensTermica;

    @JsonProperty("humedadRelativa")
    private List<PrediccionDetalle> humedadRelativa;

    @JsonProperty("vientoAndRachaMax")
    private List<VientoAndRachaMax> vientoAndRachaMax;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("orto")
    private String orto;

    @JsonProperty("ocaso")
    private String ocaso;

    //Getters and setters
    public List<EstadoCielo> getEstadoCielo() {
        return estadoCielo;
    }

    public void setEstadoCielo(List<EstadoCielo> estadoCielo) {
        this.estadoCielo = estadoCielo;
    }

    public List<PrediccionDetalle> getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(List<PrediccionDetalle> precipitacion) {
        this.precipitacion = precipitacion;
    }

    public List<PrediccionDetalle> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void setProbPrecipitacion(List<PrediccionDetalle> probPrecipitacion) {
        this.probPrecipitacion = probPrecipitacion;
    }

    public List<PrediccionDetalle> getProbTormenta() {
        return probTormenta;
    }

    public void setProbTormenta(List<PrediccionDetalle> probTormenta) {
        this.probTormenta = probTormenta;
    }

    public List<PrediccionDetalle> getNieve() {
        return nieve;
    }

    public void setNieve(List<PrediccionDetalle> nieve) {
        this.nieve = nieve;
    }

    public List<PrediccionDetalle> getProbNieve() {
        return probNieve;
    }

    public void setProbNieve(List<PrediccionDetalle> probNieve) {
        this.probNieve = probNieve;
    }

    public List<PrediccionDetalle> getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(List<PrediccionDetalle> temperatura) {
        this.temperatura = temperatura;
    }

    public List<PrediccionDetalle> getSensTermica() {
        return sensTermica;
    }

    public void setSensTermica(List<PrediccionDetalle> sensTermica) {
        this.sensTermica = sensTermica;
    }

    public List<PrediccionDetalle> getHumedadRelativa() {
        return humedadRelativa;
    }

    public void setHumedadRelativa(List<PrediccionDetalle> humedadRelativa) {
        this.humedadRelativa = humedadRelativa;
    }

    public List<VientoAndRachaMax> getVientoAndRachaMax() {
        return vientoAndRachaMax;
    }

    public void setVientoAndRachaMax(List<VientoAndRachaMax> vientoAndRachaMax) {
        this.vientoAndRachaMax = vientoAndRachaMax;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOrto() {
        return orto;
    }

    public void setOrto(String orto) {
        this.orto = orto;
    }

    public String getOcaso() {
        return ocaso;
    }

    public void setOcaso(String ocaso) {
        this.ocaso = ocaso;
    }
}