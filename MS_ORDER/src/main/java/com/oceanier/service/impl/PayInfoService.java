package com.oceanier.service.impl;

import com.oceanier.service.OrderService;
import com.oceanier.util.DateFormatUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class PayInfoService implements MessageListener {

    @Autowired
    OrderService orderService;

    public void onMessage(Message message) {
        try {
            byte[] messageByte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messageByte);
            ObjectInputStream obj = new ObjectInputStream(in);
            Map<String, String> dataMap = (Map<String, String>) obj.readObject();

            String payTimeString = dataMap.get("payTimeString");
            String tradeSerialNumber = dataMap.get("tradeSerialNumber");
            String payState = dataMap.get("payState");
            String payType = dataMap.get("payType");

            orderService.updateOrderByTradeSerialNumber(Integer.valueOf(payState), tradeSerialNumber,
                    Integer.valueOf(payType), DateFormatUtil.stringToDateWithTime(payTimeString));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("消息消费者 = " + message.toString());
    }
}
