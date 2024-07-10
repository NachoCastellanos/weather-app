package com.example.weather_app_backend.model.prediccion.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origen {

    @JsonProperty("productor")
    private String productor;

    @JsonProperty("web")
    private String web;

    @JsonProperty("enlace")
    private String enlace;

    @JsonProperty("language")
    private String language;

    @JsonProperty("copyright")
    private String copyright;

    @JsonProperty("notaLegal")
    private String notaLegal;

    //Getters and setters

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getNotaLegal() {
        return notaLegal;
    }

    public void setNotaLegal(String notaLegal) {
        this.notaLegal = notaLegal;
    }
}
