package com.oceanier.redis;

import com.oceanier.entity.ProductDetail;
import com.oceanier.service.cache.ProductDetailCacheService;
import com.oceanier.util.RedisUtil;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailRedisServiceImpl implements ProductDetailRedisService {

    @Autowired
    private ProductDetailCacheService productDetailCacheService;

    @Autowired
    private RedisUtil redisUtil;

    public ProductDetail queryProductDetailById(int productId) {
        ProductDetail productDetail = null;
        Object result = redisUtil.get("productDetail:" + productId);
        if (result == null) {
            System.out.println("come into cache");
            productDetail = productDetailCacheService.queryProductDetailById(productId);
            redisUtil.set("productDetail:" + productId, productDetail);
        } else {
            System.out.println("come into redis");
            productDetail = (ProductDetail) result;
        }
        return productDetail;
    }
}
