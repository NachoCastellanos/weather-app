package com.example.weather_app_backend.model.predicciones;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrediccionInput {
    @JsonProperty("prediccion")
    private PrediccionDias prediccionDias;

    @JsonProperty("id")
    private String id;

    // Getters and setters
    public PrediccionDias getPrediccionDias() {
        return prediccionDias;
    }
    public void setPrediccionDias(PrediccionDias prediccionDias) {
        this.prediccionDias = prediccionDias;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public static class PrediccionDias {
        @JsonProperty("dia")
        private List<Dia> dias;

        // Getters and setters
        public List<Dia> getDias() {
            return dias;
        }
        public void setDias(List<Dia> dias) {
            this.dias = dias;
        }

        public static class Dia {
            @JsonProperty("probPrecipitacion")
            private List<ProbPrecipitacion> probPrecipitacion;
            @JsonProperty("temperatura")
            private List<Temperatura> temperatura;

            // Getters and setters
            public List<ProbPrecipitacion> getProbPrecipitacion() {
                return probPrecipitacion;
            }
            public void setProbPrecipitacion(List<ProbPrecipitacion> probPrecipitacion) {
                this.probPrecipitacion = probPrecipitacion;
            }
            public List<Temperatura> getTemperatura() {
                return temperatura;
            }
            public void setTemperatura(List<Temperatura> temperatura) {
                this.temperatura = temperatura;
            }

            public static class ProbPrecipitacion implements DatosMeteorologicos {
                @JsonProperty("value")
                private String value;

                @JsonProperty("periodo")
                private String periodo;

                @Override
                public String getValue() {
                    return null;
                }

                @Override
                public void setValue(String value) {

                }

                @Override
                public String getPeriodo() {
                    return null;
                }

                @Override
                public void setPeriodo(String periodo) {

                }

                // Getters and setters
            }

            public static class Temperatura implements DatosMeteorologicos  {
                @JsonProperty("value")
                private String value;

                @JsonProperty("periodo")
                private String periodo;

                @Override
                public String getValue() {
                    return null;
                }

                @Override
                public void setValue(String value) {

                }

                @Override
                public String getPeriodo() {
                    return null;
                }

                @Override
                public void setPeriodo(String periodo) {

                }

                // Getters and setters
            }

        }
    }
}
