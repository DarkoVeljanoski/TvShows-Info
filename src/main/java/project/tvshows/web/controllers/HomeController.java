package project.tvshows.web.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import project.tvshows.model.Show;
import project.tvshows.repository.jpa.ShowsRepository;
import project.tvshows.service.JsonParsingService;
import project.tvshows.service.ShowService;



@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {

    private final static String url = "https://api.tvmaze.com/shows";
    private final ShowsRepository showsRepository;
    private final  JsonParsingService jsonService;
    private final ShowService showService;

    public HomeController(ShowsRepository showsRepository, JsonParsingService jsonService, ShowService showService ){

        this.showsRepository = showsRepository;
        this.jsonService = jsonService;
        this.showService = showService;
    }

    @GetMapping
    public String getHomePage(Model model) {

        List<Show> shows = showService.getAllShows();
        model.addAttribute("shows", shows);
        model.addAttribute("listing", "shows");
        return "listing";
    }

    @PostMapping("/search")
    public String searchShow(Model model,@RequestParam String keyword){
        List<Show> shows = this.showService.findByNameContaining(keyword);
        model.addAttribute("shows", shows);
        return "listing";
    }

}
