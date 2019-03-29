package com.oceanier.redis;

import com.oceanier.entity.ProductDetail;

public interface ProductDetailRedisService {
    public ProductDetail queryProductDetailById(int productId);
}
