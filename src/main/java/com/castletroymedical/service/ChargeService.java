package com.castletroymedical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castletroymedical.dto.ChargeDTO;
import com.castletroymedical.entity.ChargeEntity;
import com.castletroymedical.repository.BillRepository;
import com.castletroymedical.repository.ChargeRepository;

@Service
public class ChargeService {
    @Autowired
    ChargeRepository chargeRepository;
    @Autowired
    BillRepository billRepository;

    public void saveListOfCharges(List<ChargeDTO> chargeDtos, Long billId) {
        for(ChargeDTO charge : chargeDtos){ 
            charge.setBillID(billId);
            chargeRepository.save(mapToChargeEntity(charge));
        }
    }

    private ChargeEntity mapToChargeEntity(ChargeDTO chargeDTO){
        ChargeEntity charge = new ChargeEntity();
        charge.setAmount(chargeDTO.getAmount());
        charge.setDescription(chargeDTO.getDescription());
        charge.setBillID(billRepository.findById(chargeDTO.getBillID()).orElse(null));
        return charge;
    }

}