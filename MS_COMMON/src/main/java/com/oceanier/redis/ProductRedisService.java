package com.oceanier.redis;

import com.oceanier.entity.Product;

public interface ProductRedisService {

    Product queryProductById(int id);

    /**
     * 更新商品
     *
     * @param product
     */
    void updateProduct(Product product);

}
