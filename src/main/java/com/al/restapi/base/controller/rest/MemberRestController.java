package com.al.restapi.base.controller.rest;

import com.al.restapi.base.model.MemberEntity;
import com.al.restapi.base.service.member.MemberNotFoundException;
import com.al.restapi.base.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/member/{id}")
    public ResponseEntity findMemberById(@PathVariable Long id) throws MemberNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.findMemberById(id));
    }

    @PostMapping("/member")
    @Transactional
    public ResponseEntity saveMember(@Valid @RequestBody List<MemberEntity> memberEntity) throws MemberNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.saveMember(memberEntity));
    }

    @PutMapping("member/{id}")
    @Transactional
    public ResponseEntity updateMemberById(@PathVariable Long id,
                                           @Valid @RequestBody MemberEntity newMember) throws MemberNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberService.updateMemberById(id, newMember));
    }

    @DeleteMapping("/member/{id}")
    @Transactional
    public ResponseEntity deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
