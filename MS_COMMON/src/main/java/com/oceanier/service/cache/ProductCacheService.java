package com.oceanier.service.cache;

import com.oceanier.entity.Product;
import com.oceanier.vo.product.ProductVo;

import java.util.List;

public interface ProductCacheService {
    public Product queryProductById(int id);
}
