package com.oceanier.service;

import com.oceanier.dao.ProductDetailDao;
import com.oceanier.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {

    @Autowired
    ProductDetailDao productDetailDao;

    public void insertProductDetail(ProductDetail productDetail) {
        productDetailDao.insertProductDetail(productDetail);
    }

    public ProductDetail queryProductDetailById(int productId) {
        return productDetailDao.queryProductDetailById(productId);
    }

    public void deleteProductDetailById(int id) {
        productDetailDao.deleteProductDetailById(id);
    }

    public void updateProductDetail(ProductDetail productDetail) {
        productDetailDao.updateProductDetail(productDetail);
    }

}
