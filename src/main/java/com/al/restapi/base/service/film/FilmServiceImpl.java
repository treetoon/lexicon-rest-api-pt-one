package com.al.restapi.base.service.film;

import com.al.restapi.base.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl {
    @Autowired
    private FilmRepository repo;
}
