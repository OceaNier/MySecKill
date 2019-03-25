package com.oceanier.service.pay;

import org.springframework.stereotype.Service;

@Service
public class AlipayPayImpl implements AlipayPay{
    
    public int payWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("支付宝支付成功");
        return 2;
    }
    
    public int refund(String tradeSerialNumber, int payAmount) {
        System.out.println("支付宝退款成功");
        return 1;
    }
}
