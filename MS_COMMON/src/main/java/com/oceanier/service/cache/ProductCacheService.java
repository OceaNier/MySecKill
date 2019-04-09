package com.oceanier.service.cache;

import com.oceanier.entity.Product;
import com.oceanier.vo.product.ProductVo;

import java.util.List;

public interface ProductCacheService {
    Product queryProductById(int id);

    /**
     * 更新商品
     *
     * @param product
     */
    Product updateProduct(Product product);
}
