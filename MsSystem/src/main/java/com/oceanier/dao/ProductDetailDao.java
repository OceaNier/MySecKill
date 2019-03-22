package com.oceanier.dao;

import com.oceanier.entity.ProductDetail;

public interface ProductDetailDao {
    void insertProductDetail(ProductDetail productDetail);

    ProductDetail queryProductDetailById(int productId);

    void deleteProductDetailById(int id);

    void updateProductDetail(ProductDetail productDetail);

}
