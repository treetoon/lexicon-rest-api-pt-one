package com.al.restapi.base.controller.mvc;

import com.al.restapi.base.model.MemberEntity;
import com.al.restapi.base.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberMvcController {
    private MemberService memberService;

    @Autowired
    public MemberMvcController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("member-add")
    public String addMember(Model model){
        return "pages/member/member-add";
    }

    @PostMapping("/member-add")
    public String addMember(Model model, @Valid MemberEntity member) {
        try {
            List<MemberEntity> temp = new ArrayList<>();
            temp.add(member);

            memberService.saveMember(temp);
        } catch (Exception e) {
            model.addAttribute("Error: ", e.getMessage());
            return "pages/member/member-add";
        }
        return "pages/member/member-add";
    }
}
