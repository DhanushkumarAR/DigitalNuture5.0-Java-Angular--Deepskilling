package com.cognizant.fse.loanservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/status")
    public String getLoanStatus() {
        return "Loan Service is UP and running!";
    }

    @GetMapping("/types")
    public String getLoanTypes() {
        return "Available loan types: Home Loan, Car Loan, Personal Loan";
    }
}
