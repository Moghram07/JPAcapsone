package com.example.capstone1.Service;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Repository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;

    public List<MerchantStock> getMerchantStocks() {
        return merchantStockRepository.findAll();
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStockRepository.save(merchantStock);
    }

    public boolean updateMerchantStock(Integer id, MerchantStock merchantStock) {
        MerchantStock mStock = merchantStockRepository.getById(id);
        if (mStock == null) {
            return false;
        }
        mStock.setMerchantId(merchantStock.getMerchantId());
        mStock.setProductId(merchantStock.getProductId());
        mStock.setQuantity(merchantStock.getQuantity());

        merchantStockRepository.save(mStock);
        return true;
    }

    public boolean deleteMerchantStock(Integer id) {
        MerchantStock merchantStock = merchantStockRepository.getById(id);
        if (merchantStock == null) {
            return false;
        }
        merchantStockRepository.deleteById(id);
        return true;
    }

    public boolean additionalMerchantStock(int merchantId, int productId, int amount) {
        MerchantStock mStock = merchantStockRepository.findByMerchantIdAndProductId(merchantId, productId);
        if (mStock == null) {
            return false;
        }
        mStock.setQuantity(mStock.getQuantity() + amount);
        merchantStockRepository.save(mStock);
        return true;
    }

    public MerchantStock findByMerchantIdAndProductId(int merchantId, int productId) {
        return merchantStockRepository.findByMerchantIdAndProductId(merchantId, productId);
    }

    public MerchantStock getMerchantStockByProductId(int productId) {
        return merchantStockRepository.getById(productId);
    }

    public boolean reduceStock(int merchantId, int productId, int amount) {
        MerchantStock mStock = merchantStockRepository.findByMerchantIdAndProductId(merchantId, productId);
        if (mStock != null && mStock.getQuantity() >= amount) {
            mStock.setQuantity(mStock.getQuantity() - amount);
            merchantStockRepository.save(mStock);
            return true;
        }
        return false;
    }
}
