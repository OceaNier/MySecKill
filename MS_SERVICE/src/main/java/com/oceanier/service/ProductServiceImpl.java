package com.oceanier.service;

import com.oceanier.dao.ProductDao;
import com.oceanier.entity.Product;
import com.oceanier.vo.product.CustomProduct;
import com.oceanier.vo.product.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDao productDao;

    public void applyProduct(Product product) {
        String startTime = product.getStartTimeString();
        String endTime = product.getEndTimeString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            product.setStartTime(dateFormat.parse(startTime));
            product.setEndTime(dateFormat.parse(endTime));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        product.setApplyDate(new Date());
        product.setAuditState(1);
        productDao.applyProduct(product);
    }

    //根据id查询秒杀商品
    public Product queryProductById(int id) {
        return productDao.queryProductById(id);
    }

    public void deleteProductById(int id) {
        productDao.deleteProductById(id);
    }

    //更新秒杀商品
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    //更新秒杀商品状态
    public void updateProductState(int id, int state) {
        ProductVo productVo = new ProductVo();
        CustomProduct customProduct = new CustomProduct();
        customProduct.setId(id);
        customProduct.setAuditState(state);
        customProduct.setAuditDate(new Date());
        productVo.setCustomProduct(customProduct);
        productDao.updateProductState(productVo);
    }

    public List<Product> listProduct(ProductVo productVo) {
        return productDao.listProduct(productVo);
    }
}
