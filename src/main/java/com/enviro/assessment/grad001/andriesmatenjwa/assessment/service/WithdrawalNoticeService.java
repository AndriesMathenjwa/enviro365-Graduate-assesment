package com.enviro.assessment.grad001.andriesmatenjwa.assessment.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.andriesmatenjwa.assessment.Exception.NoticeException;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.dao.WithdrawalNoticeRepository;
import com.enviro.assessment.grad001.andriesmatenjwa.assessment.entity.WithdrawalNotice;
@Service
public class WithdrawalNoticeService {
      @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    public WithdrawalNotice createWithdrawalNotice(WithdrawalNotice withdrawalNotice){
        return withdrawalNoticeRepository.save(withdrawalNotice);
    }

     public List<WithdrawalNotice> createWithdrawalNotices(List<WithdrawalNotice> withdrawalNotices){
        return withdrawalNoticeRepository.saveAll(withdrawalNotices);
    }

     public WithdrawalNotice getWithdrawalNoticeById(int id){
        return withdrawalNoticeRepository.findById(id).orElse(null);
    }

  public String deleteWithdrawalNoticeById(int id) {
    Optional<WithdrawalNotice> noticeOptional = withdrawalNoticeRepository.findById(id);

    if (noticeOptional.isEmpty()) {
        throw new NoticeException("Notice not found");
    }

    WithdrawalNotice notice = noticeOptional.get();

    LocalDate currentDate = LocalDate.now();
    LocalDate noticeDate = notice.getWithdrawalDate();
    long daysDifference = ChronoUnit.DAYS.between(currentDate, noticeDate);

    if (daysDifference >= 7) {
        
        BigDecimal initialAmount = notice.getWithdrawalAmount();
        BigDecimal deduction = initialAmount.multiply(BigDecimal.valueOf(0.04));
        BigDecimal remainingAmount = initialAmount.subtract(deduction);

        notice.setWithdrawalAmount(remainingAmount);
        withdrawalNoticeRepository.deleteById(id);
        return "Notice deleted. 4% is amount deducted from the withdrawal amount.";
    } else if (daysDifference >= 1) {
        throw new NoticeException("Deletion request not allowed with more than 1 day left for notice processing");
    } else {
        throw new NoticeException("Deletion request not allowed when less than 1 day is left for notice processing");
    }
}



   public WithdrawalNotice updateWithdrawalNotice(int id, WithdrawalNotice updatedNotice) {
        WithdrawalNotice existingNotice = withdrawalNoticeRepository.findById(id).orElse(null);

        if (existingNotice != null) {
            LocalDate originalWithdrawalDate = existingNotice.getWithdrawalDate();
            LocalDate newWithdrawalDate = updatedNotice.getWithdrawalDate();

            long daysDifference = ChronoUnit.DAYS.between(originalWithdrawalDate, newWithdrawalDate);

            if (daysDifference <= 7) {
                BigDecimal penaltyPercentage = new BigDecimal("0.03");
                BigDecimal penalty = existingNotice.getWithdrawalAmount().multiply(penaltyPercentage);
                BigDecimal updatedAmount = existingNotice.getWithdrawalAmount().subtract(penalty);
                existingNotice.setWithdrawalAmount(updatedAmount);
            }

            existingNotice.setProduct(updatedNotice.getProduct());
            existingNotice.setWithdrawalDate(newWithdrawalDate);
            existingNotice.setReason(updatedNotice.getReason());
            existingNotice.setWithdrawalMethod(updatedNotice.getWithdrawalMethod());

            return withdrawalNoticeRepository.save(existingNotice);
        }
        return null; 
    }
}
