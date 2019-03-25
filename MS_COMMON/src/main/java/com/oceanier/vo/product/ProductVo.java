package com.oceanier.vo.product;

import java.io.Serializable;

public class ProductVo  implements Serializable {
    private CustomProduct customProduct;

    public CustomProduct getCustomProduct() {
        return customProduct;
    }

    public void setCustomProduct(CustomProduct customProduct) {
        this.customProduct = customProduct;
    }
}
