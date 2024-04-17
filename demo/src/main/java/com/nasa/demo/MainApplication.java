package com.nasa.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // Inicializa a aplicação Spring Boot e obtém o contexto do Spring
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        // Obtém uma instância do serviço da API da NASA do contexto do Spring
        NasaApiService nasaApiService = context.getBean(NasaApiService.class);

        // Chama o método do serviço da API da NASA para obter o retorno da API
        String apiResponse = nasaApiService.getAstronomyPictureOfTheDay();

        // Exibe o resultado formatado no formato JSON
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(apiResponse, Object.class);
            String formattedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            System.out.println("API Response:");
            System.out.println(formattedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
