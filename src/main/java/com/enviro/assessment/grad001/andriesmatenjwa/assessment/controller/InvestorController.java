package com.enviro.assessment.grad001.andriesmatenjwa.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity.Investor;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.service.InvestorService;

@RestController
public class InvestorController {
    @Autowired
    public InvestorService investorService;
    @PostMapping("/addInvestor")
    public Investor addInvestor(@RequestBody Investor investor){
         return investorService.createInvestor(investor);
    }

     @GetMapping("/investor/{id}")
     public Investor getInvestorById(@PathVariable int id){
         return investorService.getInvestorById(id);
    }

    @GetMapping("/investors")
     public List<Investor> getAllnvestors(){
         return investorService.getAllInvestors();
    }
    
}
