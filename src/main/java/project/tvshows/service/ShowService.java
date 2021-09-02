package project.tvshows.service;

import project.tvshows.model.Show;

import java.util.List;
import java.util.Optional;

public interface ShowService {

    Optional<Show> findByKeyword(String keyword);

    void saveShows(List<Show> shows);

    List<Show> getAllShows();

    List<Show> findByNameContaining(String keyword);


}
