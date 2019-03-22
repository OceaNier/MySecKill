package com.oceanier.entity;

/*

 */
public class Merchant {

    private int id;//主键

    private String merchantShopName; //商家店铺名称

    private String merchantName; //商家姓名

    private String merchantAccount; //商家账号

    private String merchantPassword; //商家密码

    private String merchantScope; //商家经营范围

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerchantShopName() {
        return merchantShopName;
    }

    public void setMerchantShopName(String merchantShopName) {
        this.merchantShopName = merchantShopName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getMerchantScope() {
        return merchantScope;
    }

    public void setMerchantScope(String merchantScope) {
        this.merchantScope = merchantScope;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", merchantShopName='" + merchantShopName + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantAccount='" + merchantAccount + '\'' +
                ", merchantPassword='" + merchantPassword + '\'' +
                ", merchantScope='" + merchantScope + '\'' +
                '}';
    }
}
