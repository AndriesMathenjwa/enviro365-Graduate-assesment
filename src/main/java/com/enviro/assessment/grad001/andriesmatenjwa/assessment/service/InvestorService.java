package com.enviro.assessment.grad001.andriesmatenjwa.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.andriesmatenjwa.assessment.dao.InvestorRepository;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity.Investor;

@Service
public class InvestorService {
    @Autowired
    private InvestorRepository investorRepository;

    public Investor createInvestor(Investor inverstor){
        return investorRepository.save(inverstor);
    }

     public Investor getInvestorById(int id){
        return investorRepository.findById(id).orElse(null);
    }

    public List<Investor> getAllInvestors() {
		return investorRepository.findAll();
	}

}