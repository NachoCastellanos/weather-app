package com.example.weather_app_backend.model;

public class Municipio {
    private String CODAUTO;
    private String CPRO;
    private String CMUN;
    private String DC;
    private String Name;

    public String getCODAUTO() {
        return CODAUTO;
    }

    public void setCODAUTO(String CODAUTO) {
        this.CODAUTO = CODAUTO;
    }

    public String getCPRO() {
        return CPRO;
    }

    public void setCPRO(String CPRO) {
        this.CPRO = CPRO;
    }

    public String getCMUN() {
        return CMUN;
    }

    public void setCMUN(String CMUN) {
        this.CMUN = CMUN;
    }

    public String getDC() {
        return DC;
    }

    public void setDC(String DC) {
        this.DC = DC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
