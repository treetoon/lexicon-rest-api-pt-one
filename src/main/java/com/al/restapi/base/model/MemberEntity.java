package com.al.restapi.base.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @OneToMany
    private List<LoanEntity> loanEntity;

    /*/////////////////////////////
    set/getters for spring bean db assignment:
    effectively choose which fields are settable
    and which are retrievable by the client
    /////////////////////////////*/

    public MemberEntity()
    {
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<LoanEntity> getLoanEntity() {
        return loanEntity;
    }

    public void setLoanEntity(List<LoanEntity> loanEntity) {
        this.loanEntity = loanEntity;
    }
}
