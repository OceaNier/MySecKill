package com.oceanier.service.pay;

import org.springframework.stereotype.Service;

@Service
public class WechatPay implements OrderToPay {
    @Override
    public int payWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("微信支付成功");
        return 2;
    }

    @Override
    public int refund(String tradeSerialNumber, int payAmount) {
        System.out.println("微信退款成功");
        return 1;
    }
}
