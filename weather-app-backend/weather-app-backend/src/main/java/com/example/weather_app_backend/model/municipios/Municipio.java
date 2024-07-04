package com.example.weather_app_backend.model.municipios;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Municipio {
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("num_hab")
    private String numHab;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("id")
    private String id;

    //Getters y Setters
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
