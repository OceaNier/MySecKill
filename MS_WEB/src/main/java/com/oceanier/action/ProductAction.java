package com.oceanier.action;

import com.oceanier.entity.Product;
import com.oceanier.redis.ProductRedisService;
import com.oceanier.service.ProductService;
import com.oceanier.service.cache.ProductCacheService;
import com.oceanier.util.DateFormatUtil;
import com.oceanier.vo.product.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("productAction")
public class ProductAction {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRedisService productRedisService;

    @RequestMapping("toApplyProduct")
    public String toApplyProduct() {
        return "product/apply";
    }

    @RequestMapping(value = "applyProduct", method = RequestMethod.POST)
    public String applyProduct(Product product) {
        productService.applyProduct(product);
        System.out.println(product);
        return "redirect:listProduct";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(HttpServletRequest request, int id) {
        Product product = productService.queryProductById(id);
        Date startTime = product.getStartTime();
        Date endTime = product.getEndTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeString = "";
        String endTimeString = "";
        if (startTime != null) {
            startTimeString = dateFormat.format(startTime);
        }
        if (endTime != null) {
            endTimeString = dateFormat.format(endTime);
        }
        product.setStartTimeString(startTimeString);
        product.setEndTimeString(endTimeString);
        request.setAttribute("product", product);

        return "product/update";
    }

    //TODO: 更新操作删除缓存
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Product product) {
        Date startTime = DateFormatUtil.stringToDate(product.getStartTimeString());
        Date endTime = DateFormatUtil.stringToDate(product.getEndTimeString());
        product.setStartTime(startTime);
        product.setEndTime(endTime);
        productService.updateProduct(product);
        System.out.println(product);
        return "redirect:listProduct";
    }

    @RequestMapping("toUpdateState")
    public String toUpdateState(HttpServletRequest request, int id) {
        Product product = productService.queryProductById(id);
        request.setAttribute("product", product);
        return "product/updateState";
    }

    @RequestMapping(value = "updateProductState", method = RequestMethod.POST)
    public String updateProductState(int id, int state) {
        productService.updateProductState(id, state);
        return "redirect:listProduct";
    }

    @RequestMapping("delete")
    public String delete(int id) {
        productService.deleteProductById(id);
        return "redirect:listProduct";
    }

    @RequestMapping("query")
    public String queryProductById(HttpServletRequest request, int id) {
        Product product = productRedisService.queryProductById(id);
        request.setAttribute("product", product);
        return "product/view";
    }

    @RequestMapping(value = "listProduct")
    public String listProduct(ProductVo productVo, HttpServletRequest request) {
        List<Product> list = productService.listProduct(productVo);
        request.setAttribute("list", list);
        return "product/list";
    }

}
