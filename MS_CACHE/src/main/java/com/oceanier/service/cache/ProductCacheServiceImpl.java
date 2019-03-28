package com.oceanier.service.cache;

import com.oceanier.entity.Product;
import com.oceanier.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductCacheServiceImpl implements ProductCacheService {

    @Autowired
    ProductService productService;

    //根据id查询秒杀商品
    @Cacheable(value = "MS_Cache", key = "'product:' + #id")
    public Product queryProductById(int id) {
        System.out.println("come into queryProductById");
        return productService.queryProductById(id);
    }
}
