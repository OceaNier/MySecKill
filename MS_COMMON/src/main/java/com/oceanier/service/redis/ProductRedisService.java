package com.oceanier.service.redis;

import com.oceanier.entity.Product;

public interface ProductRedisService {
    public Product queryProductById(int id);
}
