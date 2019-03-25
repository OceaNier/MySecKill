package com.oceanier.vo.order;

import java.io.Serializable;

public class OrderVo  implements Serializable {
    CustomOrder customOrder;

    public CustomOrder getCustomOrder() {
        return customOrder;
    }

    public void setCustomOrder(CustomOrder customOrder) {
        this.customOrder = customOrder;
    }
}
