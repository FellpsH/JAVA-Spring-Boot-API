package com.nasa.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nasa")
public class NasaController {

    private final NasaApiService nasaApiService;

    public NasaController(NasaApiService nasaApiService) {
        this.nasaApiService = nasaApiService;
    }

    @GetMapping("/apod")
    public String getAstronomyPictureOfTheDay() {
        return nasaApiService.getAstronomyPictureOfTheDay();
    }
}
