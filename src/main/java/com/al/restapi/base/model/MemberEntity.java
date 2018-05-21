package com.al.restapi.base.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @Email
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
