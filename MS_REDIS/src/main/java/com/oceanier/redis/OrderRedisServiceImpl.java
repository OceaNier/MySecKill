package com.oceanier.redis;

import com.oceanier.entity.Order;
import com.oceanier.util.DateFormatUtil;
import com.oceanier.util.RedisUtil;
import com.oceanier.vo.order.CustomOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class OrderRedisServiceImpl implements OrderRedisService {

    @Autowired
    private RedisUtil redisUtil;

    // rabbitmq
    @Autowired
    private AmqpTemplate amqpTemplate;


    public Map<String, Object> secKill(int userId, int productId, CustomOrder order) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int stockCount = order.getStockCount();
        if (redisUtil.getKeyListSize(productId + "") > stockCount) {
            System.out.println("秒杀失败！");
            resultMap.put("success", false);
        }
        redisUtil.pushList(productId + "", userId + "");
        System.out.println("秒杀成功！");
        String key = "userId:" + userId + "==productId:" + productId;
        String value = "";

        String createTimeString = DateFormatUtil.dateToStringWithTime(new Date());
        String merchantId = order.getMerchantId() + "";
        String receivingName = order.getReceivingName();
        String payAmount = order.getPayAmount() + "";
        String receivingAddress = order.getReceivingAddress();
        String receivingPhone = order.getReceivingPhone() + "";
        String tradeSerialNumber = createTimeString + UUID.randomUUID();
        int payState = 1;

        //生成订单信息value
        value += payState + "==" + tradeSerialNumber + "==" + createTimeString + "==" + merchantId + "==" + payAmount
                + "==" + receivingAddress + "==" + receivingName + "==" + receivingPhone + "==" + stockCount;
        redisUtil.set(key, value);
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("createTime", createTimeString);
        dataMap.put("merchantId", merchantId);
        dataMap.put("payAmount", payAmount);
        dataMap.put("receivingAddress", receivingAddress);
        dataMap.put("receivingName", receivingName);
        dataMap.put("receivingPhone", receivingPhone);
        dataMap.put("stockCount", stockCount + "");
        dataMap.put("tradeSerialNumber", tradeSerialNumber);
        dataMap.put("payState", payState + "");
        dataMap.put("productId", productId + "");
        dataMap.put("userId", userId + "");

        amqpTemplate.convertAndSend("ms_exchange", "orderInfo", dataMap);

        resultMap.put("success", true);
        resultMap.put("dataMap", dataMap);
        return resultMap;
    }

    //更改支付状态
    public boolean payOrder(int payType, int userId, int productId, int merchantId, String tradeSerialNumber, int payAmount) {
        String key = "userId:" + userId + "==productId:" + productId;
        String value = (String) redisUtil.get(key);
        String[] splitValues = value.split("==");
        splitValues[0] = "2";
        value = "";
        for (String temp : splitValues) {
            value += temp + "==";
        }
        boolean success = redisUtil.set(key, value);

        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("tradeSerialNumber", tradeSerialNumber);
        dataMap.put("payState", "2");
        String payTimeString = DateFormatUtil.dateToStringWithTime(new Date());
        dataMap.put("payTimeString", payTimeString);
        dataMap.put("payType", payType + "");
        amqpTemplate.convertAndSend("ms_exchange", "payInfo", dataMap);

        return success;
    }

    public List<Order> queryOrderByUserId(int userId) {
        List<Order> orderList = new ArrayList<Order>();
        Set<String> keys = redisUtil.getKeys("userId:" + userId);
        for (String key : keys) {
            String[] keyInfo = key.split("==");
            String productId = keyInfo[1].split(":")[1];
            String userIdString = keyInfo[0].split(":")[1];
            String value = (String) redisUtil.get(key);
            String[] valueArray = value.split("==");

            String payState = valueArray[0];
            String tradeSerialNumber = valueArray[1];
            String createTimeString = valueArray[2];
            String merchantId = valueArray[3];
            String payAmount = valueArray[4];
            String receivingAddress = valueArray[5];
            String receivingName = valueArray[6];
            String receivingPhone = valueArray[7];
            String stockCount = valueArray[8];

            Order order = new Order();

            order.setCreateTime(DateFormatUtil.stringToDateWithTime(createTimeString));
            order.setPayState(Integer.valueOf(payState));
            order.setTradeSerialNumber(tradeSerialNumber);
            order.setMerchantId(Integer.valueOf(merchantId));
            order.setPayAmount(Integer.valueOf(payAmount));
            order.setReceivingAddress(receivingAddress);
            order.setReceivingName(receivingName);
            order.setReceivingPhone(Integer.valueOf(receivingPhone));
            order.setUserId(userId);
            order.setProductId(Integer.valueOf(productId));
            order.setCount(1);

            orderList.add(order);
        }
        return orderList;
    }
}
