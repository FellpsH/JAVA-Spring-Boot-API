package com.nasa.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NasaApiService {

    private final String BASE_URL = "https://api.nasa.gov/";
    private final String API_KEY = "ObyXCUXSSainzrMJPBfe7Eb3qgvh0Lm22j1R2Dru";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public NasaApiService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public String getAstronomyPictureOfTheDay() {
        String url = BASE_URL + "planetary/apod?api_key=" + API_KEY;
        String jsonResponse = restTemplate.getForObject(url, String.class);
        try {
            Object jsonObject = objectMapper.readValue(jsonResponse, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while formatting JSON response";
        }
    }
}
