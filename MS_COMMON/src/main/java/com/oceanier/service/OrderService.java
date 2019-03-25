package com.oceanier.service;

import com.oceanier.entity.Order;

import java.util.List;

public interface OrderService {

    public void insertOrder(Order order);

    public Order queryOrderById(int id);

    public void deleteOrderById(int id);

    public List<Order> queryOrderByUserId(int userId);

    public List<Order> queryOrderByMerchantId(int merchantId);

    public void updateOrderPayState(int payState, int id, int payType);
}
