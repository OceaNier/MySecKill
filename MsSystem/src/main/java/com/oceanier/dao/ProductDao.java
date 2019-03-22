package com.oceanier.dao;

import com.oceanier.entity.Product;
import com.oceanier.vo.product.ProductVo;

import java.util.List;

public interface ProductDao {

    void applyProduct(Product product);

    Product queryProductById(int id);

    void deleteProductById(int id);

    void updateProduct(Product product);

    void updateProductState(ProductVo productVo);

    List<Product> listProduct(ProductVo productVo);
}
