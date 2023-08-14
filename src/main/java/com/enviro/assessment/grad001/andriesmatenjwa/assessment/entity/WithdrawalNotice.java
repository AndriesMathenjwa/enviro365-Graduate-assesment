package com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

//import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WithdrawalNotice {
    @Id
    @GeneratedValue
    private int id;
    private String product;
    private LocalDate withdrawalDate;
    private BigDecimal withdrawalAmount;
    private String reason;            // Reason for the withdrawal
    private String withdrawalMethod;  // Method used for the withdrawal (e.g., bank transfer, check) 

    // Add setters for fields you want to update
    public void setProduct(String product) {
        this.product = product;
    }

    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setWithdrawalMethod(String withdrawalMethod) {
        this.withdrawalMethod = withdrawalMethod;
    }
}
