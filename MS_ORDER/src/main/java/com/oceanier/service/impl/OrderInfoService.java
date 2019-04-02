package com.oceanier.service.impl;

import com.oceanier.entity.Order;
import com.oceanier.service.OrderService;
import com.oceanier.util.DateFormatUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class OrderInfoService implements MessageListener {
    @Autowired
    OrderService orderService;

    public void onMessage(Message message) {
        try {
            byte[] messageByte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messageByte);
            ObjectInputStream obj = new ObjectInputStream(in);
            Map<String, String> dataMap = (Map<String, String>) obj.readObject();

            String createTime = dataMap.get("createTime");
            String merchantId = dataMap.get("merchantId");
            String payAmount = dataMap.get("payAmount");
            String receivingAddress = dataMap.get("receivingAddress");
            String receivingName = dataMap.get("receivingName");
            String receivingPhone = dataMap.get("receivingPhone");
            String stockCount = dataMap.get("stockCount");
            String tradeSerialNumber = dataMap.get("tradeSerialNumber");
            String payState = dataMap.get("payState");
            String productId = dataMap.get("productId");
            String userId = dataMap.get("userId");

            Order order = new Order();

            order.setCreateTime(DateFormatUtil.stringToDateWithTime(createTime));
            order.setMerchantId(Integer.valueOf(merchantId));
            order.setPayAmount(Integer.valueOf(payAmount));
            order.setReceivingAddress(receivingAddress);
            order.setReceivingName(receivingName);
            order.setReceivingPhone(Integer.valueOf(receivingPhone));
            order.setTradeSerialNumber(tradeSerialNumber);
            order.setPayState(Integer.valueOf(payState));
            order.setProductId(Integer.valueOf(productId));
            order.setUserId(Integer.valueOf(userId));

            orderService.insertOrder(order);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("消息消费者 = " + message.toString());
    }
}
