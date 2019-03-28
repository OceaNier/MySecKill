package com.oceanier.service;

import com.oceanier.entity.ProductDetail;
import com.oceanier.service.cache.ProductDetailCacheService;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailCacheServiceImpl implements ProductDetailCacheService {

    public ProductDetail queryProductDetailById(int productId) {
        System.out.println("queryProductDetailById");
        return null;
    }
}
