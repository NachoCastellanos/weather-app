package com.example.weather_app_backend.service;

import com.example.weather_app_backend.model.input.PrediccionDetalle;
import com.example.weather_app_backend.model.input.PrediccionMunicipio;
import com.example.weather_app_backend.model.municipios.Municipio;
import com.example.weather_app_backend.model.output.PrediccionResponse;
import com.example.weather_app_backend.model.output.ProbPrecipitacion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AemetService {

    private final String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYWNobzJjYXNtb3JAZ21haWwuY29tIiwianRpIjoiMmNiZmMxMmItOTRmMS00YzI5LWI5MzYtYTQwYzhhMTVkZjExIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE3MTkzMDIxMzEsInVzZXJJZCI6IjJjYmZjMTJiLTk0ZjEtNGMyOS1iOTM2LWE0MGM4YTE1ZGYxMSIsInJvbGUiOiIifQ.MbGWQgW3DRdofVq5n7YG5KaF6rEiLl0dsw9WwZGc-F8";
    private final String BASE_URL = "https://opendata.aemet.es/opendata/api";

    private RestTemplate restTemplate;

    public AemetService() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("ISO-8859-15")));
    }

    public List<Municipio> getAllMunicipios() {
        String url = BASE_URL + "/maestro/municipios?api_key=" + API_KEY;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api_key", API_KEY);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            String datosUrl = (String) response.getBody().get("datos");

            ResponseEntity<String> datosResponse = restTemplate.getForEntity(datosUrl, String.class);
            String datos = datosResponse.getBody();

            ObjectMapper mapper = new ObjectMapper();
            List<Municipio> municipios = mapper.readValue(datos, new TypeReference<List<Municipio>>() {
            });

            return municipios;
        } catch (HttpClientErrorException | JsonProcessingException e) {
            // manejar la excepción
            return null;
        }
    }

    public PrediccionResponse getPrediccionMunicipio(String idMunicipio) {
        String url = BASE_URL + "/prediccion/especifica/municipio/horaria/" + idMunicipio + "?api_key=" + API_KEY;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api_key", API_KEY);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            System.out.println("URL final: " + url);

            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            String datosUrl = (String) response.getBody().get("datos");

            System.out.println("URL de datos: " + datosUrl); // Línea añadida

            ResponseEntity<String> datosResponse = restTemplate.getForEntity(datosUrl, String.class);
            String datos = datosResponse.getBody();

            System.out.println("Datos JSON: " + datos);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            PrediccionMunicipio prediccionMunicipio = mapper.readValue(datos, PrediccionMunicipio.class);

            System.out.println("Objeto PrediccionHoraria: " + prediccionMunicipio);

            return transformarAPrediccionResponse(prediccionMunicipio);


        } catch (HttpClientErrorException | JsonProcessingException e) {
            // manejar la excepción
            return null;
        }
    }

    private PrediccionResponse transformarAPrediccionResponse(PrediccionMunicipio prediccionMunicipio) {
        PrediccionResponse prediccionResponse = new PrediccionResponse();

        // Calcula la media de las temperaturas y la establece en el objeto de respuesta
        double mediaTemperatura = calcularMediaTemperatura(prediccionMunicipio);
        prediccionResponse.setMediaTemperatura(mediaTemperatura);

        // Extrae los datos de probabilidad de precipitación y los establece en el objeto de respuesta
        List<ProbPrecipitacion> probPrecipitacion = extraerProbPrecipitacion(prediccionMunicipio);
        prediccionResponse.setProbPrecipitacion(probPrecipitacion);

        return prediccionResponse;
    }

    private double calcularMediaTemperatura(PrediccionMunicipio prediccionMunicipio) {
        double sum = 0.0;
        int count = 0;

        for (PrediccionDetalle detalle : prediccionMunicipio.getPrediccionDias().getDias().get(0).getTemperatura()) {
            sum += Double.parseDouble(detalle.getValue());
            count++;
        }

        return count > 0 ? sum / count : 0;
    }

    private List<ProbPrecipitacion> extraerProbPrecipitacion(PrediccionMunicipio prediccionMunicipio) {
        List<ProbPrecipitacion> probPrecipitaciones = new ArrayList<>();

        for (PrediccionDetalle detalle : prediccionMunicipio.getPrediccionDias().getDias().get(0).getProbPrecipitacion()) {
            ProbPrecipitacion probPrecipitacion = new ProbPrecipitacion();
            probPrecipitacion.setProbabilidad(Integer.parseInt(detalle.getValue()));
            String fecha = detalle.getFecha();
            String formattedFecha = fecha.substring(0, 2) + ":" + fecha.substring(2);
            probPrecipitacion.setFecha(formattedFecha);
        }

        return probPrecipitaciones;
    }
}
