package com.oceanier.service;
import com.oceanier.entity.Merchant;
import com.oceanier.vo.merchant.MerchantVo;

import java.util.List;
public interface MerchantService {

    public void insertMerchant(Merchant merchant);

    public Merchant queryMerchantById(int id);

    public Merchant queryMerchantByAccount(String account);

    public void deleteMerchantById(int id);

    public void updateMerchant(Merchant merchant);

    public List<Merchant> queryMerchantByVo(MerchantVo merchantVo);
}
