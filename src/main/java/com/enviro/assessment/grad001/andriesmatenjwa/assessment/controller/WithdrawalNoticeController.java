package com.enviro.assessment.grad001.andriesmatenjwa.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.Exception.NoticeException;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.service.WithdrawalNoticeService;

@RestController
public class WithdrawalNoticeController {
     @Autowired
    public WithdrawalNoticeService withdrawalNoticeService;
    @PostMapping("/addWithdrawalNotice")
    public WithdrawalNotice addWithdrawalNotice(@RequestBody WithdrawalNotice withdrawalNotice){
         return withdrawalNoticeService.createWithdrawalNotice(withdrawalNotice);
    }

     @GetMapping("/withdrawalNotice/{id}")
     public WithdrawalNotice getWithdrawalNoticeById(@PathVariable int id){
         return withdrawalNoticeService.getWithdrawalNoticeById(id);
    }

    @DeleteMapping("/withdrawalNotice/{id}")
    public String deleteWithdrawalNotice(@PathVariable int id) {
    try {
        return withdrawalNoticeService.deleteWithdrawalNoticeById(id);
    } catch (NoticeException ex) {
        return "Error: " + ex.getMessage();
    }
}


     @PutMapping("/updateWithdrawalNotice/{id}")
    public WithdrawalNotice updateWithdrawalNotice(@PathVariable int id, @RequestBody WithdrawalNotice updatedNotice) {
        return withdrawalNoticeService.updateWithdrawalNotice(id, updatedNotice);
    }
}
