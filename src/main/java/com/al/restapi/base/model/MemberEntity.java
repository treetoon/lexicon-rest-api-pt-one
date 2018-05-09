package com.al.restapi.base.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @OneToOne
    private LoanEntity loanEntity;
}
