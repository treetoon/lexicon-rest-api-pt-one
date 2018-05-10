package com.al.restapi.base.service.film;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmRepository repo;

    @Autowired
    public FilmServiceImpl(FilmRepository repo) {
        this.repo = repo;
    }

    /**
     * Returns the entire film list or partially,
     * based on search args
     * @param title film title
     * @param genre film genre
     * @return a list of film objects
     */
    @Override
    public List<FilmEntity> findFilms(String title, String genre){

        if(genre != null && title != null)
            return repo.findByTitleAndGenre(title, genre);
        else if(title != null)
            return repo.findByTitle(title);
        else if(genre != null)
            return repo.findByGenre(genre);
        else
            return repo.findAll();
    }

    @Override
    public List<FilmEntity> saveFilm(List<FilmEntity> filmEntity){
        return repo.saveAll(filmEntity);
    }

    @Override
    public Optional<FilmEntity> findFilmById(Long id) {
        return repo.findById(id);
    }
}
