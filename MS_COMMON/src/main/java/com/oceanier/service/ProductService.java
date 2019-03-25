package com.oceanier.service;

import com.oceanier.entity.Product;
import com.oceanier.vo.product.ProductVo;
import java.util.List;

public interface ProductService {

    public void applyProduct(Product product);
    //根据id查询秒杀商品
    public Product queryProductById(int id);

    public void deleteProductById(int id);

    //更新秒杀商品
    public void updateProduct(Product product);
    //更新秒杀商品状态
    public void updateProductState(int id, int state);

    public List<Product> listProduct(ProductVo productVo);
}
