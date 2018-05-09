package com.al.restapi.base.model; //model/domain

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filmId;

    @NotBlank
    private Integer amount; //amount of a specific book

    @NotBlank
    private String title;

    @NotBlank //create special JPA annotation?
    private String ISBN;

    @NotBlank //create special JPA annotation?
    private String genre;

    @NotBlank //create special JPA annotation?
    private String pos;


    //does spring use get setters?
}
