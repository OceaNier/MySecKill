package com.oceanier.service;

import com.oceanier.dao.MerchantDao;
import com.oceanier.entity.Merchant;
import com.oceanier.vo.merchant.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {

    @Autowired
    MerchantDao merchantDao;

    public void insertMerchant(Merchant merchant){
        merchantDao.insertMerchant(merchant);
    }

    public Merchant queryMerchantById(int id){
        return merchantDao.queryMerchantById(id);
    }

    public Merchant queryMerchantByAccount(String account){
        return merchantDao.queryMerchantByAccount(account);
    }

    public void deleteMerchantById(int id){
        merchantDao.deleteMerchantById(id);
    }

    public void updateMerchant(Merchant merchant){
        merchantDao.updateMerchant(merchant);
    }

    public List<Merchant> queryMerchantByVo(MerchantVo merchantVo){
        return merchantDao.queryMerchantByVo(merchantVo);
    }
}
