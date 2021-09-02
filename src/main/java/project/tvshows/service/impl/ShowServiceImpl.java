package project.tvshows.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.tvshows.model.Show;
import project.tvshows.repository.jpa.ShowsRepository;
import project.tvshows.service.ShowService;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowsRepository showsRepository;

    public ShowServiceImpl(ShowsRepository showsRepository){
        this.showsRepository = showsRepository;
    }

    @Override
    public Optional<Show> findByKeyword(String keyword) {
        return showsRepository.findByKeyword(keyword);
    }

    @Override
    public void saveShows(List<Show> shows) {
        showsRepository.saveAll(shows);
    }

    @Override
    public List<Show> getAllShows() {
        return showsRepository.findAll();
    }

    @Override
    @Transactional
    public List<Show> findByNameContaining(String keyword) {
        return showsRepository.findAllByNameContaining(keyword);
    }


}
