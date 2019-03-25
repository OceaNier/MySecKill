package com.oceanier.vo.merchant;

import java.io.Serializable;

public class MerchantVo implements Serializable{
    private CustomMerchant customMerchant;

    public CustomMerchant getCustomMerchant() {
        return customMerchant;
    }

    public void setCustomMerchant(CustomMerchant customMerchant) {
        this.customMerchant = customMerchant;
    }
}
