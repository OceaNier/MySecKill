package com.oceanier.action;

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
@RequestMapping("pageHomeAction")
public class PageHomeAction {

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
        ProductDetail productDetail = productDetailRedisService.queryProductDetailById(productId);
        Product product = productRedisService.queryProductById(productId);
        request.setAttribute("product", product);
        request.setAttribute("productDetail", productDetail);
        return "order/sellDetail";
    }

    @RequestMapping("produceHtml")
    public String produceHtml(HttpServletRequest request) {
        String htmlPath = request.getRealPath("/WEB-INF/html/");
        String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        contextPath = contextPath + "/pageHomeAction/toHome";
        System.out.println(contextPath);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(contextPath);
        CloseableHttpResponse response = null;

        try {
            //3.执行请求，获取响应
            response = client.execute(httpGet);
            //看请求是否成功，这儿打印的是http状态码
            System.out.println(response.getStatusLine().getStatusCode());
            //4.获取响应的实体内容，就是我们所要抓取得网页内容
            HttpEntity entity = response.getEntity();
            //5.将其打印到控制台上面
            //方法一：使用EntityUtils
            if (entity != null) {
                String html = EntityUtils.toString(entity);
                File file = new File(htmlPath + "/index.html");//存到应用的static目录下
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));
                writer.write(html);
                writer.flush();
                writer.close();
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "homePage/homePage";
    }

    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String account = "";
        if (user != null) {
            account = user.getUserAccount();
        }
        return account;
    }

    @RequestMapping("produceJs")
    public void produceJs(HttpServletRequest request) {
        String jsPath = request.getRealPath("/WEB-INF/js");
        String jsContent = "function remainTime(){" + "\n" +
                "var startTime = $(\"#startTime\").html();" + "\n" +
                "var s1 = new Date(startTime.replace(\"/-/g\",\"/\"));" + "\n" +
                "var s2 = new Date();" + "\n" +
                "var date3 = s1.getTime() - s2.getTime();" + "\n" +
                "if(date3 > 2){" + "\n" +
                "$(\"#sellBtn\").attr({\"disabled\":\"disabled\"});" + "\n" +
                "var days = Math.floor(date3/(24*3600*1000));" + "\n" +
                "var hours = Math.floor(date3%(24*3600*1000)/(3600*1000));" + "\n" +
                "var minutes = Math.floor(date3%(3600*1000)/(60*1000));" + "\n" +
                "var seconds = Math.floor(date3%(60*1000)/1000)" + "\n" +
                "$(\"#remainTime\").html(\"剩余\"+days+\"天\"+ hours + \" 小时\" + minutes + \" 分钟\"+seconds+\"秒\");" + "\n" +
                "}else{" + "\n" +
                "$(\"#remainTime\").html(\"\");" + "\n" +
                "$(\"#sellBtn\").removeAttr(\"disabled\");" + "\n" +
                "$(\"#sellBtn\").parent().attr(\"action\",\"/orderAction/toPayOrder\");" + "\n" +
                "}" + "\n" +
                "}" + "\n" +
                "setInterval('remainTime()',500);";

        File file = new File(jsPath + "/remain.js");
        Writer writer = null;
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file), "utf-8"));
            writer.write(jsContent);
            writer.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
}
