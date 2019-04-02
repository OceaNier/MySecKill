package com.oceanier.service;

import com.oceanier.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    void insertOrder(Order order);

    Order queryOrderById(int id);

    void deleteOrderById(int id);

    List<Order> queryOrderByUserId(int userId);

    List<Order> queryOrderByMerchantId(int merchantId);

    void updateOrderPayState(int payState, int id, int payType);

    void updateOrderByTradeSerialNumber(int payState, String tradeSerialNumber, int payType, Date payTime);

}
