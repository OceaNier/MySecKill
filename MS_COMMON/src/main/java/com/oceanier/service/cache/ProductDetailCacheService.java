package com.oceanier.service.cache;

import com.oceanier.entity.ProductDetail;

public interface ProductDetailCacheService {
    public ProductDetail queryProductDetailById(int productId);

    public String getDataFromDB(String key);
}
