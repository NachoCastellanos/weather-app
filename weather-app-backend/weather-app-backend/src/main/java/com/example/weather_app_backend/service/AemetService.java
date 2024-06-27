package com.example.weather_app_backend.service;

import com.example.weather_app_backend.model.clima.PrediccionHoraria;
import com.example.weather_app_backend.model.municipios.Municipio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
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

    public PrediccionHoraria getPrediccionHoraria(String idMunicipio) {
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

            ObjectMapper mapper = new ObjectMapper();
            PrediccionHoraria prediccionHoraria = mapper.readValue(datos, PrediccionHoraria.class);

            System.out.println("Objeto PrediccionHoraria: " + prediccionHoraria);

            return prediccionHoraria;
        } catch (HttpClientErrorException | JsonProcessingException e) {
            // manejar la excepción
            return null;
        }
    }
}
