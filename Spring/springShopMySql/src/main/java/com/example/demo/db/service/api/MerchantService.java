package com.example.demo.db.service.api;

import com.example.demo.domain.Merchant;
import org.springframework.lang.Nullable;

import java.util.List;

public interface MerchantService {

    List<Merchant> getMerchants();
    @Nullable
    Merchant getM(int id);
    @Nullable
    Integer addMerchant(Merchant merchant);
}
