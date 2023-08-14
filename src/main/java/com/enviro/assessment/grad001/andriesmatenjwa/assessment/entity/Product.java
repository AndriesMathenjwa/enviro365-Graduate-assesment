package com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity;

import java.math.BigDecimal;
// import java.time.LocalDate;

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
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String type;  
    private String name;
    private BigDecimal currentBalance;
}
