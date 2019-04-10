package com.oceanier.action;

import com.oceanier.entity.Merchant;
import com.oceanier.entity.Order;
import com.oceanier.entity.Product;
import com.oceanier.entity.User;
import com.oceanier.redis.OrderRedisService;
import com.oceanier.redis.ProductRedisService;
import com.oceanier.service.OrderService;
import com.oceanier.service.ProductService;
import com.oceanier.service.pay.*;
import com.oceanier.vo.order.CustomOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("orderAction")
public class OrderAction {

    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    AlipayPay alipayPay;
    @Autowired
    WechatPay wechatPay;
    @Autowired
    BankCardPay bankCardPay;

    @Autowired
    ProductRedisService productRedisService;

    @Autowired
    OrderRedisService orderRedisService;

    @RequestMapping(value = "payOrder", method = RequestMethod.POST)
    public String payOrder(CustomOrder order, HttpServletRequest request) {
        String returnUrl = "redirect:/pageHomeAction/toHome";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {

            //防刷单处理
            long time = orderRedisService.getUserVisitTime(user.getId());
            long currentTime = System.currentTimeMillis();
            long timeDiff = currentTime - time;
            long seconds = timeDiff / 1000;
            long times = orderRedisService.visitTimes(user.getId());
            if (times / seconds > 10) {
                System.out.println("非法访问！");
                return returnUrl;
            }

            Map<String, Object> resultMap = orderRedisService.secKill(user.getId(), order.getProductId(), order);
            boolean success = (boolean) resultMap.get("success");
            if (success) {
                System.out.println("秒杀成功！");
                Map<String, String> dataMap = (Map<String, String>) resultMap.get("dataMap");
                String merchantId = dataMap.get("merchantId");
                String payAmount = dataMap.get("payAmount");
                String tradeSerialNumber = dataMap.get("tradeSerialNumber");
                String productId = dataMap.get("productId");
                String userId = dataMap.get("userId");

                returnUrl = "redirect:/orderAction/toPayWithOrder?userId=" + userId + "&productId=" + productId + "&tradeSerialNumber=" + tradeSerialNumber + "&payAmount=" + payAmount + "&merchantId=" + merchantId;
            } else {
                System.out.println("秒杀失败！");

            }
        } else {
            request.setAttribute("errorInfo", "您还未登录，请先登录！");
            returnUrl = "user/userLogin";
        }
        return returnUrl;
    }

    @RequestMapping("toPayOrder")
    public String toPayOrder(HttpServletRequest request, int id, int count) {
        Product product = productRedisService.queryProductById(id);
        int payAmount = product.getMiaoshaPrice() * count;
        request.setAttribute("product", product);
        request.setAttribute("count", count);
        request.setAttribute("payAmount", payAmount);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            request.setAttribute("userId", user.getId());
        } else {
            request.setAttribute("errorInfo", "您还未登录，请先登录！");
            return "user/userLogin";
        }
        return "order/payOrder";
    }

    @RequestMapping(value = "queryOrderByUserId")
    public String queryOrderByUserId(HttpServletRequest request) {
        String returnUrl = "user/userLogin";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Order> list = orderRedisService.queryOrderByUserId(user.getId());
            request.setAttribute("list", list);
            returnUrl = "order/listOrder";
        } else {
            request.setAttribute("errorInfo", "用户未登录！");
        }
        return returnUrl;
    }

    @RequestMapping(value = "queryOrderByMerchantId")
    public String queryOrderByMerchantId(HttpServletRequest request) {
        String returnUrl = "merchant/merchantLogin";
        HttpSession session = request.getSession();
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if (merchant != null) {
            List<Order> list = orderService.queryOrderByMerchantId(merchant.getId());
            request.setAttribute("list", list);
            returnUrl = "order/listMerchantOrder";
        } else {
            request.setAttribute("errorInfo", "用户未登录！");
        }
        return returnUrl;
    }

    @RequestMapping(value = "toPayWithOrder")
    public String toPayWithOrder(HttpServletRequest request, int userId, int productId, String tradeSerialNumber, int payAmount, int merchantId) {
        request.setAttribute("userId", userId);
        request.setAttribute("productId", productId);
        request.setAttribute("merchantId", merchantId);
        request.setAttribute("tradeSerialNumber", tradeSerialNumber);
        request.setAttribute("payAmount", payAmount);
        return "order/payReal";
    }

    /**
     * @param payType           1支付宝 2微信 3银联
     * @param tradeSerialNumber
     * @return
     */
    @RequestMapping(value = "payWithOrder")
    public String payWithOrder(int payType, int userId, int productId, int merchantId, String tradeSerialNumber, int payAmount) {
        int payState = 1;//默认支付失败
        if (payType == 1) {
            payState = alipayPay.payWithOrder(tradeSerialNumber, payAmount);
        } else if (payType == 2) {
            payState = wechatPay.payWithOrder(tradeSerialNumber, payAmount);
        } else if (payType == 3) {
            payState = bankCardPay.payWithOrder(tradeSerialNumber, payAmount);
        }

        if (payState == 2) {
            boolean success = orderRedisService.payOrder(payType, userId, productId, merchantId, tradeSerialNumber, payAmount);
            if (success) {
                System.out.println("支付成功！");
            } else {
                System.out.println("保存失败！");
            }
        }
        return "redirect:queryOrderByUserId";
    }

    @RequestMapping(value = "applyRefund")
    public String applyRefund(HttpServletRequest request, String tradeSerialNumber) {
        String returnUrl = "user/userLogin";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            orderRedisService.updateOrderByTradeSerialNumber("update", user.getId(), 4, tradeSerialNumber, -1);
            returnUrl = "redirect:/orderAction/queryOrderByUserId";
        } else {
            request.setAttribute("errorInfo", "用户未登录！");
        }
        return returnUrl;
    }

    @RequestMapping(value = "auditRefund")
    public String auditRefund(HttpServletRequest request, int userId, int payType, int payState, String tradeSerialNumber) {
        String returnUrl = "merchant/merchantLogin";
        HttpSession session = request.getSession();
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if (merchant != null) {
            orderRedisService.updateOrderByTradeSerialNumber("refund", userId, payState, tradeSerialNumber, payType);
        } else {
            request.setAttribute("errorInfo", "用户未登录！");
        }
        return returnUrl;
    }
}
