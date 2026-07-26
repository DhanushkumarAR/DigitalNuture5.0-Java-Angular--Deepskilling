package com.cognizant.fse.accountservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/status")
    public String getAccountStatus() {
        return "Account Service is UP and running!";
    }

    @GetMapping("/details")
    public String getAccountDetails() {
        return "Account details for user 123: Balance $1000.00";
    }
}
