package com.al.restapi.base.model; //model/domain

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Film")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;

    @NotBlank
    private String title;

    @NotBlank //create special JPA annotation?
    private String ISBN;

    @NotBlank //create special JPA annotation?
    private String genre;

    @NotBlank //create special JPA annotation?
    private String pos;

    @NotNull
    @Min(0)
    private Integer loanedCopies;

    @NotNull
    @Min(1)
    private Integer copies;

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

    public Integer getLoanedCopies() {
        return loanedCopies;
    }

    public void setLoanedCopies(Integer loanedCopies) {
        this.loanedCopies = loanedCopies;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }
}
