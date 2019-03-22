package com.oceanier.entity;

public class ProductDetail {

    private int id;//主键
    private int productId;//商品id
    private int merchantId;//商家id
    private String productPlace;//产地
    private String productName;//商品名称
    private String brand;//品牌
    private String productWeight;//商品重量
    private String specification;//规格描述
    private String productDetailPicture;//商品详情图片地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProductDetailPicture() {
        return productDetailPicture;
    }

    public void setProductDetailPicture(String productDetailPicture) {
        this.productDetailPicture = productDetailPicture;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", productId=" + productId +
                ", merchantId=" + merchantId +
                ", productPlace='" + productPlace + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", productWeight='" + productWeight + '\'' +
                ", specification='" + specification + '\'' +
                ", productDetailPicture='" + productDetailPicture + '\'' +
                '}';
    }
}
