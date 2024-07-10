package com.example.weather_app_backend.model.prediccion.output;

import com.example.weather_app_backend.model.prediccion.input.Dia;

public class PrediccionOutput {

    private String id;
    private String nombre;
    private DiaResumido diaResumido;

    // Constructor
    public PrediccionOutput(String id, String nombre, DiaResumido diaResumido) {
        this.id = id;
        this.nombre = nombre;
        this.diaResumido = diaResumido;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DiaResumido getDiaResumido() {
        return diaResumido;
    }

    public void setDiaResumido(Dia dia) {
        this.diaResumido = diaResumido;
    }
}
