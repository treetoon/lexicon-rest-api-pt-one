package com.al.restapi.base.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Temporal(TemporalType.TIMESTAMP) //date conversion between java and db types
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedDate;

    @OneToMany
    private List<FilmEntity> filmEntity;

    /*/////////////////////////////
    set/getters for db assignment
    /////////////////////////////*/

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<FilmEntity> getFilmEntity() {
        return filmEntity;
    }

    public void setFilmEntity(List<FilmEntity> filmEntity) {
        this.filmEntity = filmEntity;
    }
}
