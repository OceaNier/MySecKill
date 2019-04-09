package com.oceanier.action.newPageHome;

import com.oceanier.entity.Product;
import com.oceanier.entity.ProductDetail;
import com.oceanier.entity.User;
import com.oceanier.redis.ProductDetailRedisService;
import com.oceanier.redis.ProductRedisService;
import com.oceanier.service.OrderService;
import com.oceanier.service.ProductDetailService;
import com.oceanier.service.ProductService;
import com.oceanier.util.DateFormatUtil;
import com.oceanier.vo.product.CustomProduct;
import com.oceanier.vo.product.ProductVo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("newPageHomeAction")
public class NewPageHomeAction {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductDetailRedisService productDetailRedisService;

    @Autowired
    ProductRedisService productRedisService;

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        ProductVo productVo = new ProductVo();
        CustomProduct customProduct = new CustomProduct();
        Date now = new Date();
        String nowString = DateFormatUtil.dateToString(now);
        customProduct.setAuditState(2);
        customProduct.setStartEndDate(nowString);
        productVo.setCustomProduct(customProduct);
        List<Product> list = productService.listProduct(productVo);
        request.setAttribute("list", list);
        return "newHomePage/index";
    }

    @RequestMapping("viewProductDetail")
    public String viewProductDetail(HttpServletRequest request, int id) {
        ProductDetail productDetail = productDetailRedisService.queryProductDetailById(id);
        Product product = productRedisService.queryProductById(id);
        request.setAttribute("product", product);
        request.setAttribute("productDetail", productDetail);
        return "newHomePage/seckill-item";
    }
}
