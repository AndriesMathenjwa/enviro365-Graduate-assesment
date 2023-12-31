package com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity;


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
public class Investor {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
}

