package project.tvshows;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.tvshows.model.Show;

import project.tvshows.service.ShowService;

import java.io.InputStream;
import java.util.List;

import java.io.IOException;


@SpringBootApplication
public class TvshowsApplication {



    public static void main(String[] args) {
        SpringApplication.run(TvshowsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ShowService showService) {
        return args -> {
            // read JSON and load json
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Show>> typeReference = new TypeReference<List<Show>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/allShow.json");
            try {
                List<Show> shows = mapper.readValue(inputStream, typeReference);
                showService.saveShows(shows);
                System.out.println("Shows Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save shows: " + e.getMessage());
            }
        };
    }


}


