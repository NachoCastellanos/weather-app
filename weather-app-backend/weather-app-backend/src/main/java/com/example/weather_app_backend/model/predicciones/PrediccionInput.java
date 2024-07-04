package com.example.weather_app_backend.model.predicciones;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PrediccionInput {
    @JsonProperty("prediccion")
    private PrediccionDias prediccionDias;

    @JsonProperty("id")
    private String id;

    // Getters and setters

    public static class PrediccionDias {
        @JsonProperty("dia")
        private List<Dia> dias;

        // Getters and setters

        public static class Dia {
            @JsonProperty("probPrecipitacion")
            private List<ProbPrecipitacion> probPrecipitacion;
            @JsonProperty("temperatura")
            private List<Temperatura> temperatura;

            // Getters and setters

            public static class ProbPrecipitacion implements DatosMeteorologicos {
                @JsonProperty("value")
                private String value;

                @JsonProperty("periodo")
                private String periodo;

                // Getters and setters
                @Override
                public String getValue() {
                    return value;
                }

                @Override
                public void setValue(String value) {
                    this.value = value;
                }

                @Override
                public String getPeriodo() {
                    return periodo;
                }

                @Override
                public void setPeriodo(String periodo) {
                    this.periodo = periodo;
                }
            }

            public static class Temperatura implements DatosMeteorologicos {
                @JsonProperty("value")
                private String value;

                @JsonProperty("periodo")
                private String periodo;

                // Getters and setters
            }

        }
    }
}
