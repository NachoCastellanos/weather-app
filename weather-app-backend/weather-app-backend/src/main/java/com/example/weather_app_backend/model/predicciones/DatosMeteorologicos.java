package com.example.weather_app_backend.model.predicciones;

public interface DatosMeteorologicos {
    String getValue();
    void setValue(String value);
    String getPeriodo();
    void setPeriodo(String periodo);
}