package com.oceanier.service;

import com.oceanier.entity.Product;
import com.oceanier.service.cache.ProductCacheService;
import org.springframework.stereotype.Service;

@Service
public class ProductCacheServiceImpl implements ProductCacheService{

    //根据id查询秒杀商品
    public Product queryProductById(int id) {
        System.out.println("queryProductDetailById");
        return null;
    }
}
