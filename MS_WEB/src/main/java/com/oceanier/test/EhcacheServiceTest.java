package com.oceanier.test;

import com.oceanier.service.cache.ProductCacheService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EhcacheServiceTest extends SpringTestCase {

    @Autowired
    private ProductCacheService productCacheService;

    @Test
    public void queryById(){
        productCacheService.queryProductById(1);
        productCacheService.queryProductById(1);
        System.out.println(productCacheService.queryProductById(1).getId());
    }
}
