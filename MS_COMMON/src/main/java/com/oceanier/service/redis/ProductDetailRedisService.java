package com.oceanier.service.redis;

import com.oceanier.entity.ProductDetail;

public interface ProductDetailRedisService {
    public ProductDetail queryProductDetailById(int productId);

    public String getDataFromDB(String key);
}
