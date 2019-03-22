package com.oceanier.dao;

import com.oceanier.entity.Order;
import com.oceanier.vo.order.OrderVo;

import java.util.List;

public interface OrderDao {

    void insertOrder(Order order);

    Order queryOrderById(int id);

    void deleteOrderById(int id);

    void updateOrderPayState(OrderVo orderVo);

    List<Order> queryOrderByUserId(int userId);

    List<Order> queryOrderByMerchantId(int merchantId);
}
