package com.oceanier.dao;

import com.oceanier.entity.Merchant;
import com.oceanier.vo.merchant.MerchantVo;

import java.util.List;

public interface MerchantDao {

    void insertMerchant(Merchant merchant);

    Merchant queryMerchantById(int id);

    Merchant queryMerchantByAccount(String account);

    void deleteMerchantById(int id);

    void updateMerchant(Merchant merchant);

    List<Merchant> queryMerchantByVo(MerchantVo merchantVo);
}
