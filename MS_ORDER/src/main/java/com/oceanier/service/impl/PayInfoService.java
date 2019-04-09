package com.oceanier.service.impl;

import com.oceanier.service.OrderService;
import com.oceanier.service.pay.AlipayPay;
import com.oceanier.service.pay.BankCardPay;
import com.oceanier.service.pay.WechatPay;
import com.oceanier.util.DateFormatUtil;
import org.omg.CORBA.INTERNAL;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class PayInfoService implements MessageListener {

    @Autowired
    OrderService orderService;

    @Autowired
    AlipayPay alipayPay;
    @Autowired
    WechatPay wechatPay;
    @Autowired
    BankCardPay bankCardPay;


    public void onMessage(Message message) {
        try {
            byte[] messageByte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messageByte);
            ObjectInputStream obj = new ObjectInputStream(in);
            Map<String, String> dataMap = (Map<String, String>) obj.readObject();

            String flag = dataMap.get("flag");
            if (flag.equals("update")) {
                String tradeSerialNumber = dataMap.get("tradeSerialNumber");
                String payState = dataMap.get("payState");
                orderService.updateOrderByTradeSerialNumber1(Integer.valueOf(payState), tradeSerialNumber);
            } else if ("refund".equals(flag)) {
                String tradeSerialNumber = dataMap.get("tradeSerialNumber");
                String payStateString = dataMap.get("payState");
                String payTypeString = dataMap.get("payType");
                String payAmountString = dataMap.get("payAmount");

                int payState = Integer.valueOf(payStateString);
                int payType = Integer.valueOf(payTypeString);
                int payAmount = Integer.valueOf(payAmountString);

                if (payState == 3) {
                    int refundResult = 0;
                    if (payType == 1) {
                        refundResult = alipayPay.refund(tradeSerialNumber, payAmount);
                    } else if (payType == 2) {
                        refundResult = wechatPay.refund(tradeSerialNumber, payAmount);
                    } else if (payType == 3) {
                        refundResult = bankCardPay.refund(tradeSerialNumber, payAmount);
                    }
                    if (refundResult == 1) {
                        orderService.updateOrderByTradeSerialNumber1(payState, tradeSerialNumber);
                    }
                } else if (payState == 5) {
                    orderService.updateOrderByTradeSerialNumber1(payState, tradeSerialNumber);
                }

            } else {
                String payTimeString = dataMap.get("payTimeString");
                String tradeSerialNumber = dataMap.get("tradeSerialNumber");
                String payState = dataMap.get("payState");
                String payType = dataMap.get("payType");

                orderService.updateOrderByTradeSerialNumber(Integer.valueOf(payState), tradeSerialNumber,
                        Integer.valueOf(payType), DateFormatUtil.stringToDateWithTime(payTimeString));
            }
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }
        System.out.println("消息消费者 = " + message.toString());
    }
}
