package com.enviro.assessment.grad001.andriesmatenjwa.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity.WithdrawalNotice;

public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Integer> {
    
}
