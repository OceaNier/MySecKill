package com.oceanier.redis;

import com.oceanier.entity.Order;
import com.oceanier.vo.order.CustomOrder;

import java.util.List;
import java.util.Map;

public interface OrderRedisService {
    Map<String, Object> secKill(int userId, int productId, CustomOrder order);

    boolean payOrder(int payType, int userId, int productId, int merchantId, String tradeSerialNumber, int payAmount);

    List<Order> queryOrderByUserId(int userId);
}
