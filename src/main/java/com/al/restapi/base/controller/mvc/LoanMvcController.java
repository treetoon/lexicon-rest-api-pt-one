package com.al.restapi.base.controller.mvc;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.service.film.FilmService;
import com.al.restapi.base.service.loan.LoanNotFoundException;
import com.al.restapi.base.service.loan.LoanService;
import com.al.restapi.base.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoanMvcController {
    private LoanService loanService;
    private FilmService filmService;
    private MemberService memberService;

    @Autowired
    public LoanMvcController(LoanService loanService,
                             FilmService filmService,
                             MemberService memberService) {
        this.loanService = loanService;
        this.filmService = filmService;
        this.memberService = memberService;
    }

    @GetMapping("/loan")
    public String getLoan(Model model){
        try {
            model.addAttribute("loanList", loanService.findLoans());
        } catch (LoanNotFoundException e) {
            model.addAttribute("Error: ", e.getMessage());
            return "pages/loan/loan";
        }
        return "pages/loan/loan";
    }

    @GetMapping("/loan-add")
    public String addLoan(Model model){
        try{
            model.addAttribute("filmList", filmService.findFilms());
            //model.addAttribute("memberList", memberService.findMemberById());
        } catch (Exception e) {
            model.addAttribute("Error: ", e.getMessage());
            return "pages/loan/loan";
        }
        return "pages/loan/loan-add";
    }

    @PostMapping("/loan-add")
    public String addLoan(Model model, /*@Valid*/ @ModelAttribute("selectedFilms") FilmEntity selectedFilms /*, @Valid Long Id*/) {
        try {
            System.out.println(selectedFilms + " " + selectedFilms.getFilmId());


            //loanService.createLoan(Id, selectedFilms);
            model.addAttribute("loanList", loanService.findLoans());
        } catch (Exception e) {
            model.addAttribute("Error: ", e.getMessage());
            return "pages/loan/loan-add";
        }
        return "pages/loan/loan";
    }
}
