package com.al.restapi.base.controller.rest;

import com.al.restapi.base.service.film.FilmNotFoundException;
import com.al.restapi.base.service.member.MemberNotFoundException;
import com.al.restapi.base.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-api")
public class MemberRestController {

    private MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public ResponseEntity findMembers(@RequestParam(required = false) String name) throws MemberNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.findMembers(name));
    }
}
