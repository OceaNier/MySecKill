package com.oceanier.vo.order;

import com.oceanier.entity.Order;

public class CustomOrder extends Order {
    private int stockCount;

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
