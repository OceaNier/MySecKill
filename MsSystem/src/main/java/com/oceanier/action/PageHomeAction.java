package com.oceanier.action;

import com.oceanier.entity.Product;
import com.oceanier.entity.ProductDetail;
import com.oceanier.service.OrderService;
import com.oceanier.service.ProductDetailService;
import com.oceanier.service.ProductService;
import com.oceanier.util.DateFormatUtil;
import com.oceanier.vo.product.CustomProduct;
import com.oceanier.vo.product.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pageHomeAction")
public class PageHomeAction {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    OrderService orderService;

    @RequestMapping("toHome")
    public String toHome(HttpServletRequest request) {
        ProductVo productVo = new ProductVo();
        CustomProduct customProduct = new CustomProduct();
        Date now = new Date();
        String nowString = DateFormatUtil.dateToString(now);
        customProduct.setStartEndDate(nowString);
        customProduct.setAuditState(2);
        productVo.setCustomProduct(customProduct);
        List<Product> list = productService.listProduct(productVo);
        request.setAttribute("list", list);
        return "homePage/homePage";
    }

    @RequestMapping("viewProductDetail")
    public String viewProductDetail(HttpServletRequest request, int productId) {
        ProductDetail productDetail = productDetailService.queryProductDetailById(productId);
        Product product = productService.queryProductById(productId);
        request.setAttribute("product", product);
        request.setAttribute("productDetail", productDetail);
        return "order/sellDetail";
    }
}
