package com.naksha.restapi.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contoller {
    @GetMapping("/expenses")
    public String getExpenses(){
        return "Reading the expenses from database";
    }
}
