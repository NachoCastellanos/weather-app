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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

@Service
public class AemetService {

    private final String BASE_URL = "https://opendata.aemet.es/opendata/api";
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public AemetService(@Value("${aemet.token}") String token) {
        // Crear una instancia de RestTemplate para realizar solicitudes HTTP
        this.restTemplate = new RestTemplate();

        // Configurar el RestTemplate para soportar tanto texto plano como JSON en las respuestas
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

    public PrediccionMunicipio getPrediccionMunicipio(String idMunicipio) {
        String url = BASE_URL + "/prediccion/especifica/municipio/horaria/" + idMunicipio;
        try {
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Paso 1: Obtener la URL de los datos
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            String datosUrl = (String) response.getBody().get("datos");
            System.out.println("URL de datos: " + datosUrl);

            // Paso 2: Realizar solicitud a la URL de los datos
            ResponseEntity<PrediccionMunicipio> datosResponse = restTemplate.exchange(datosUrl, HttpMethod.GET, entity, PrediccionMunicipio.class);
            PrediccionMunicipio prediccionMunicipio = datosResponse.getBody();

            // Respuesta
            return prediccionMunicipio;

        } catch (Exception e) {
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
