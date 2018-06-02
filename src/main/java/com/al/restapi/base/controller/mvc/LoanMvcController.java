package com.al.restapi.base.controller.mvc;

import com.al.restapi.base.service.loan.LoanNotFoundException;
import com.al.restapi.base.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanMvcController {
    private LoanService loanService;

    @Autowired
    public LoanMvcController(LoanService loanService) {
        this.loanService = loanService;
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
}
