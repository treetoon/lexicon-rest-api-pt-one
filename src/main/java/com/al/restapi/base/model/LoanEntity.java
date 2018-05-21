package com.al.restapi.base.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Loan")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @CreatedDate
    private LocalDateTime loanDate;

    @LastModifiedDate
    private LocalDateTime returnDate;

    @OneToMany
    private List<FilmEntity> filmList;

    @ManyToOne
    private MemberEntity member;

    /*/////////////////////////////
    set/getters for spring bean db assignment:
    effectively choose which fields are settable
    and which are retrievable by the client
    /////////////////////////////*/

    public LoanEntity()
    {
    }

    public Long getLoanId() {
        return loanId;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public List<FilmEntity> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<FilmEntity> filmList) {
        this.filmList = filmList;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }
}
