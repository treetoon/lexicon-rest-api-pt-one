package com.al.restapi.base.model; //model/domain

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Film")
public class FilmEntity {

    //TODO Cascading?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;

    private Boolean isLoaned = false;

    @NotBlank
    private String title;

    @NotBlank //TODO create special JPA annotation?
    private String ISBN;

    @NotBlank //create special JPA annotation?
    private String genre;

    @NotBlank //create special JPA annotation?
    private String pos;

    /*/////////////////////////////
    set/getters for spring bean db assignment:
    effectively choose which fields are settable
    and which are retrievable by the client
    /////////////////////////////*/

    public FilmEntity()
    {
    }

    public Long getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Boolean getLoaned() {
        return isLoaned;
    }

    public void setLoaned(Boolean loaned) {
        isLoaned = loaned;
    }
}
