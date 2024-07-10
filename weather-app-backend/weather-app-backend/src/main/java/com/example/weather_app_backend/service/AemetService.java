package com.example.weather_app_backend.service;

import com.example.weather_app_backend.model.municipios.Municipio;
import com.example.weather_app_backend.model.prediccion.input.Dia;
import com.example.weather_app_backend.model.prediccion.input.PrediccionDetalle;
import com.example.weather_app_backend.model.prediccion.input.PrediccionInput;
import com.example.weather_app_backend.model.prediccion.output.DiaResumido;
import com.example.weather_app_backend.model.prediccion.output.PrediccionOutput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class AemetService {

    private final String BASE_URL = "https://opendata.aemet.es/opendata/api";
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public AemetService(@Value("${aemet.token}") String token) {
        // Crear una instancia de RestTemplate para realizar solicitudes HTTP
        this.restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
        restTemplate.getMessageConverters().add(0, converter);
        // Inicializar HttpHeaders y configurar el tipo de contenido a JSON
        // y añadir el token de la API como cabecera de autorización
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api_key", token);
    }

    public List<Municipio> getAllMunicipios() {
        String url = BASE_URL + "/maestro/municipios";
        try {
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Paso 1: Obtener la URL de los datos
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            String datosUrl = (String) response.getBody().get("datos");

            // Paso 2: Realizar solicitud a la URL de los datos
            ResponseEntity<Municipio[]> datosResponse = restTemplate.exchange(datosUrl, HttpMethod.GET, entity, Municipio[].class);
            Municipio[] municipiosArray = datosResponse.getBody();

            // Convertir el arreglo a lista para mantener la consistencia con el tipo de retorno
            return Arrays.asList(municipiosArray);

        } catch (Exception e) {
            // manejar la excepción
            return null;
        }
    }

    public DiaResumido getPrediccionMunicipio(String idMunicipio) {
        String url = BASE_URL + "/prediccion/especifica/municipio/horaria/" + idMunicipio;
        DiaResumido diaResumido = null;

        try {
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Paso 1: Obtener la URL de los datos
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            String datosUrl = (String) response.getBody().get("datos");
            System.out.println("URL de datos: " + datosUrl);

            // Paso 2: Realizar solicitud a la URL de los datos
            ResponseEntity<PrediccionInput[]> datosResponse = restTemplate.exchange(datosUrl, HttpMethod.GET, entity, PrediccionInput[].class);
            PrediccionInput[] prediccionInput = datosResponse.getBody();

            // Paso 3: Procesar los datos y extraer la información relevante
            if (prediccionInput[0].getPrediccion() != null && !prediccionInput[0].getPrediccion().getDia().isEmpty()) {
                // Asumiendo que queremos el primer objeto Dia
                Dia diaSeleccionado = prediccionInput[0].getPrediccion().getDia().get(1);
                List<PrediccionDetalle> temperatura = diaSeleccionado.getTemperatura();
                List<PrediccionDetalle> probPrecipitacion = diaSeleccionado.getProbPrecipitacion();
                diaResumido = new DiaResumido(temperatura, probPrecipitacion);
            }
            // Paso 4: Retornar la información procesada
            return diaResumido;
        } catch (Exception e) {
            // manejar la excepción
            return null;
        }
    }

    /*
        public List<PrediccionOutput> getPrediccionMunicipio(String idMunicipio) {
        String url = BASE_URL + "/prediccion/especifica/municipio/horaria/" + idMunicipio;
        List<PrediccionOutput> prediccionOutput = new ArrayList<>();

        try {
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Paso 1: Obtener la URL de los datos
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            String datosUrl = (String) response.getBody().get("datos");
            System.out.println("URL de datos: " + datosUrl);

            // Paso 2: Realizar solicitud a la URL de los datos
            ResponseEntity<PrediccionInput[]> datosResponse = restTemplate.exchange(datosUrl, HttpMethod.GET, entity, PrediccionInput[].class);
            PrediccionInput[] prediccionInput = datosResponse.getBody();

            // Paso 3: Procesar los datos y extraer la información relevante
            if (prediccionInput[0].getPrediccion() != null && !prediccionInput[0].getPrediccion().getDia().isEmpty()) {
                // Asumiendo que queremos el primer objeto Dia
                Dia diaSeleccionado = prediccionInput[0].getPrediccion().getDia().get(1);
                List<PrediccionDetalle> temperatura = diaSeleccionado.getTemperatura();
                List<PrediccionDetalle> probPrecipitacion = diaSeleccionado.getProbPrecipitacion();
                DiaResumido diaResumido = new DiaResumido(temperatura, probPrecipitacion);

                prediccionOutput.add(new PrediccionOutput(prediccionInput[0].getId(), prediccionInput[0].getNombre(), diaResumido));
            }
            // Paso 4: Retornar la información procesada
            return prediccionOutput;

        } catch (Exception e) {
            // manejar la excepción
            return null;
        }
    }
    */


}
