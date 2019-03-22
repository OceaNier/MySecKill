package com.oceanier.service.pay;

import org.springframework.stereotype.Service;

@Service
public class BankCardPay implements OrderToPay{
    @Override
    public int payWithOrder(String tradeSerialNumber, int payAmount) {
        System.out.println("银行卡支付成功");
        return 2;
    }

    @Override
    public int refund(String tradeSerialNumber, int payAmount) {
        System.out.println("银行卡退款成功");
        return 1;
    }
}
