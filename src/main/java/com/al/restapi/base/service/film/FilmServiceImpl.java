package com.al.restapi.base.service.film;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository repo;

    public FilmServiceImpl()
    {
    }

    public List<FilmEntity> findAllFilms(){
        return repo.findAll();
    }

    public FilmEntity saveFilm(FilmEntity filmEntity){
        return repo.save(filmEntity);
    }
}
