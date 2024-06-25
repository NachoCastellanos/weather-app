package com.example.weather_app_backend.service;

import com.example.weather_app_backend.model.Municipio;
import com.example.weather_app_backend.model.Prediccion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;
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
            List<Municipio> municipios = mapper.readValue(datos, new TypeReference<List<Municipio>>(){});

            return municipios;
        } catch (HttpClientErrorException | JsonProcessingException e) {
            // manejar la excepción
            return null;
        }
    }

    public Prediccion getPrediccion(String codigoMunicipio, String unidadTemperatura) {
        if (unidadTemperatura == null) {
            unidadTemperatura = "G_CEL";
        }

        String url = BASE_URL + "/prediccion/provincia/manana/" + codigoMunicipio + "?api_key=" + API_KEY;
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
            Prediccion prediccion = mapper.readValue(datos, Prediccion.class);

            if ("G_FAH".equals(unidadTemperatura)) {
                prediccion.setTemperaturaMedia(convertCelsiusToFahrenheit(prediccion.getTemperaturaMedia()));
            }
            prediccion.setUnidadMedidaTemperatura(unidadTemperatura);

            return prediccion;
        } catch (HttpClientErrorException | JsonProcessingException e) {
            // manejar la excepción
            return null;
        }
    }

    private double convertCelsiusToFahrenheit(double celsius) {
        return celsius * 9/5 + 32;
    }
}
