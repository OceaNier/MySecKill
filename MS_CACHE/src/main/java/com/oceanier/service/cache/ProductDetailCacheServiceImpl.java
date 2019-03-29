package com.oceanier.service.cache;

import com.oceanier.entity.ProductDetail;
import com.oceanier.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailCacheServiceImpl implements ProductDetailCacheService {

    @Autowired
    ProductDetailService productDetailService;

    @Cacheable(value = "MS_Cache", key = "'productDetail:' + #id")
    public ProductDetail queryProductDetailById(int productId) {
        System.out.println("come into queryProductDetailById");
        return productDetailService.queryProductDetailById(productId);
    }

}
