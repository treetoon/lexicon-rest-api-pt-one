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
    public List<FilmEntity> findFilms(String title, String genre) throws FilmNotFoundException {

        if(genre != null && title != null) {
            if (repo.findByTitleAndGenre(title, genre).isEmpty()) {
                throw new FilmNotFoundException("Title (" + title + "), Genre (" + genre +
                        "), search could not find any results...");
            } else {
                return repo.findByTitleAndGenre(title, genre);
            }
        }else if(title != null) {
            if (repo.findByTitle(title).isEmpty()) {
                throw new FilmNotFoundException("Title (" + title +
                        "), search could not find any results...");
            } else {
                return repo.findByTitle(title);
            }
        }else if(genre != null) {
            if (repo.findByGenre(genre).isEmpty()) {
                throw new FilmNotFoundException("Genre (" + genre +
                        "), search could not find any results...");
            } else {
                return repo.findByGenre(genre);
            }
        }else {
            if (repo.findAll().isEmpty()) {
                throw new FilmNotFoundException("Film list is empty...");
            } else {
                return repo.findAll();
            }
        }
    }

    @Override
    public Optional<FilmEntity> findFilmById(Long id) throws FilmNotFoundException {
        if (repo.findById(id).isPresent())
            return repo.findById(id);
        else
            throw new FilmNotFoundException("Film id is out of range...");
    }

    @Override
    public List<FilmEntity> saveFilm(List<FilmEntity> filmEntity) throws FilmNotFoundException {
        if(!repo.saveAll(filmEntity).isEmpty())
            return repo.saveAll(filmEntity);
        else
            throw new FilmNotFoundException("No films in the list...");
    }

    /**
     * Updates the selected film based on id
     * @param id id of film to be updated
     * @param newFilm new film object used to update
     * @return updated film object
     * @throws FilmNotFoundException
     */
    @Override
    public Optional<FilmEntity> updateFilmById(Long id, FilmEntity newFilm) throws FilmNotFoundException {
        Optional<FilmEntity> currentFilm = repo.findById(id);

        if(currentFilm.isPresent() && newFilm != null){
            currentFilm.get().setTitle(newFilm.getTitle());
            currentFilm.get().setISBN(newFilm.getISBN());
            currentFilm.get().setGenre(newFilm.getGenre());
            currentFilm.get().setPos(newFilm.getPos());
            currentFilm.get().setLoanedCopies(newFilm.getLoanedCopies());
            currentFilm.get().setCopies(newFilm.getCopies());

            repo.save(currentFilm.get());
            return currentFilm; //returns updated film
        }else{
            throw new FilmNotFoundException("Could not update film...");
        }
    }

    @Override
    public void deleteFilmById(Long id){
        repo.deleteById(id);
    }
}
