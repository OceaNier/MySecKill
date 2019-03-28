package com.oceanier.redis;

import com.oceanier.entity.ProductDetail;
import com.oceanier.service.ProductDetailService;
import com.oceanier.service.redis.ProductDetailRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailRedisServiceImpl implements ProductDetailRedisService {

    @Autowired
    ProductDetailService productDetailService;

    @Cacheable(value = "MS_Cache", key = "'productDetail:' + #id")
    public ProductDetail queryProductDetailById(int productId) {
        System.out.println("come into queryProductDetailById");
        return productDetailService.queryProductDetailById(productId);
    }

    @Cacheable(value = "HelloWorldCache", key = "#key")
    public String getDataFromDB(String key) {
        System.out.println("从数据库中获取数据...");
        return key + ":" + String.valueOf(Math.round(Math.random() * 1000000));
    }
}
