package com.oceanier.redis;

import com.oceanier.entity.Product;
import com.oceanier.service.cache.ProductCacheService;
import com.oceanier.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRedisServiceImpl implements ProductRedisService {

    @Autowired
    private ProductCacheService productCacheService;

    @Autowired
    private RedisUtil redisUtil;

    //根据id查询秒杀商品
    public Product queryProductById(int id) {
        Product product = null;
        Object result = redisUtil.get("product:" + id);
        //如果从redis没有取到
        if (result == null) {
            System.out.println("come into cache");
            //去缓存中取
            product = productCacheService.queryProductById(id);
            redisUtil.set("product:" + id, product);
        } else {
            System.out.println("come into redis");
            product = (Product) result;
        }
        return product;
    }
}
