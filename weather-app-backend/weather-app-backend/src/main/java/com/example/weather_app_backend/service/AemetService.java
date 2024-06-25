package com.example.weather_app_backend.service;

import com.example.weather_app_backend.model.Municipio;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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
    }

    public List<Municipio> getAllMunicipios() {
        String url = BASE_URL + "/api/maestro/municipios?api_key=" + API_KEY;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api_key", API_KEY);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            String datosUrl = (String) response.getBody().get("datos");

            ResponseEntity<Municipio[]> datosResponse = restTemplate.getForEntity(datosUrl, Municipio[].class);
            return Arrays.asList(datosResponse.getBody());
        } catch (HttpClientErrorException e) {
            // manejar la excepción
            return null;
        }
    }
}