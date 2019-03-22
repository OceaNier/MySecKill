package com.oceanier.service.pay;

/**
 * 支付
 */
public interface OrderToPay {

    /**
     * @param tradeSerialNumber
     * @param payAmount
     * @return 1支付成功  2支付失败
     */
    int payWithOrder(String tradeSerialNumber, int payAmount);

    int refund(String tradeSerialNumber, int payAmount);
}
