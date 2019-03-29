package com.oceanier.action;

import com.oceanier.entity.ProductDetail;
import com.oceanier.redis.ProductDetailRedisService;
import com.oceanier.service.ProductDetailService;
import com.oceanier.service.cache.ProductDetailCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("productDetailAction")
public class ProductDetailAction {

    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    ProductDetailRedisService productDetailRedisService;

    @RequestMapping("toAdd")
    public String toAddProductDetail(HttpServletRequest request, int productId, int merchantId) {
        request.setAttribute("productId", productId);
        request.setAttribute("merchantId", merchantId);
        return "productDetail/add";
    }

    @RequestMapping(value = "addProductDetail", method = RequestMethod.POST)
    public String applyProduct(ProductDetail productDetail) {
        productDetailService.insertProductDetail(productDetail);
        System.out.println(productDetail);
        return "redirect:query?productId=" + productDetail.getProductId();
    }

    @RequestMapping("toUpdate")
    public String toUpdate(HttpServletRequest request, int productId) {
        ProductDetail productDetail = productDetailService.queryProductDetailById(productId);
        request.setAttribute("productDetail", productDetail);
        return "productDetail/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(ProductDetail productDetail) {
        productDetailService.updateProductDetail(productDetail);
        System.out.println(productDetail);
        return "redirect:query?productId=" + productDetail.getProductId();
    }


    @RequestMapping("delete")
    public String delete(int id) {
        productDetailService.deleteProductDetailById(id);
        return "redirect:product/list";
    }

    @RequestMapping("query")
    public String queryProductDetailById(HttpServletRequest request, int productId) {
        ProductDetail productDetail = productDetailRedisService.queryProductDetailById(productId);
        request.setAttribute("productDetail", productDetail);
        return "productDetail/view";
    }

}
