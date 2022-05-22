package com.example.demo.db.service.impl;

import com.example.demo.db.repository.MerchantRepository;
import com.example.demo.db.service.api.MerchantService;
import com.example.demo.domain.Merchant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantImpl implements MerchantService {
    private final MerchantRepository merchantRepository;

    public MerchantImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<Merchant> getMerchants() {
        return merchantRepository.getMerchants();
    }

    @Override
    public Merchant getM(int id) {
        return merchantRepository.getMerchant(id);
    }

    @Override
    public Integer addMerchant(Merchant merchant) {
        return merchantRepository.addMerchant(merchant);
    }
}
