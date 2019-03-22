package com.oceanier.action;

import com.oceanier.entity.Merchant;
import com.oceanier.entity.Order;
import com.oceanier.entity.Product;
import com.oceanier.entity.User;
import com.oceanier.service.OrderService;
import com.oceanier.service.ProductService;
import com.oceanier.service.pay.AlipayPay;
import com.oceanier.service.pay.BankCardPay;
import com.oceanier.service.pay.WechatPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "payOrder", method = RequestMethod.POST)
    public String payOrder(Order order) {
        Date now = new Date();
        order.setCreateTime(now);
        order.setPayState(1);
        String tradeSerialNumber = UUID.randomUUID().toString();
        order.setTradeSerialNumber(tradeSerialNumber);
        orderService.insertOrder(order);
        return "redirect:/pageHomeAction/toHome";
    }

    @RequestMapping("toPayOrder")
    public String toPayOrder(HttpServletRequest request, int id, int count) {
        Product product = productService.queryProductById(id);
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
            List<Order> list = orderService.queryOrderByUserId(user.getId());
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
    public String toPayWithOrder(HttpServletRequest request, int id, String tradeSerialNumber, int payAmount) {
        request.setAttribute("id", id);
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
    public String payWithOrder(int payType, int id, String tradeSerialNumber, int payAmount) {
        int payState = 1;//默认支付失败
        if (payType == 1) {
            payState = alipayPay.payWithOrder(tradeSerialNumber, payAmount);
        } else if (payType == 2) {
            payState = wechatPay.payWithOrder(tradeSerialNumber, payAmount);
        } else if (payType == 3) {
            payState = bankCardPay.payWithOrder(tradeSerialNumber, payAmount);
        }

        if (payState == 2) {
            orderService.updateOrderPayState(payState, id, payType);
        }
        return "redirect:queryOrderByUserId";
    }

    @RequestMapping(value = "applyRefund")
    public String applyRefund(HttpServletRequest request, int orderId, int payType) {
        String returnUrl = "user/userLogin";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            orderService.updateOrderPayState(4, orderId, payType);
            returnUrl = "redirect:/orderAction/queryOrderByUserId";
        } else {
            request.setAttribute("errorInfo", "用户未登录！");
        }
        return returnUrl;
    }

    @RequestMapping(value = "auditRefund")
    public String auditRefund(HttpServletRequest request, int orderId, int payType, int payState, int payAmount, String tradeSerialNumber) {
        String returnUrl = "merchant/merchantLogin";
        HttpSession session = request.getSession();
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if (merchant != null) {
            if (payState == 3) {
                int refundResult = 0;
                if (payType == 1) {
                    refundResult = alipayPay.refund(tradeSerialNumber, payAmount);
                } else if (payType == 2) {
                    refundResult = wechatPay.refund(tradeSerialNumber, payAmount);
                } else if (payType == 3) {
                    refundResult = bankCardPay.refund(tradeSerialNumber, payAmount);
                }
                if (refundResult == 1){
                    orderService.updateOrderPayState(payState,orderId,payType);
                    returnUrl = "redirect:/orderAction/queryOrderByMerchantId";
                }
            } else if (payState == 5) {
                orderService.updateOrderPayState(payState,orderId,payType);
                returnUrl = "redirect:/orderAction/queryOrderByMerchantId";
            }
        } else {
            request.setAttribute("errorInfo", "用户未登录！");
        }
        return returnUrl;
    }
}
