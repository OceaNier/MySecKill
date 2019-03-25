package com.oceanier.service;

import com.oceanier.entity.ProductDetail;
public interface ProductDetailService {

    public void insertProductDetail(ProductDetail productDetail);

    public ProductDetail queryProductDetailById(int productId);

    public void deleteProductDetailById(int id);
    public void updateProductDetail(ProductDetail productDetail);
}
