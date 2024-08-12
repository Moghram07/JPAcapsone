package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;

    public List<Merchant> getMerchants() {
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    public boolean updateMerchant(Integer id, Merchant merchant) {
        Merchant m = merchantRepository.getById(id);
        if (m == null) {
            return false;
        }
        m.setMerchantName(merchant.getMerchantName());
        m.setEmail(merchant.getEmail());
        m.setAddress(merchant.getAddress());
        m.setPhone(merchant.getPhone());

        merchantRepository.save(m);
        return true;
    }

    public boolean removeMerchant(Integer id) {
        Merchant m = merchantRepository.getById(id);
        if (m == null) {
            return false;
        }
        merchantRepository.delete(m);
        return true;
    }

}
