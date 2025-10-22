package com.thamco.shop.order.fulfilment.service;

public interface OrderUpdateService
{
    /**
     * Request an order be marked as fulfilled
     * @param orderId The ID of the order to mark as fulfilled
     * @return HTTP status code as {@code String}
     */
    String requestMarkOrderAsFulfilled(int orderId);
}
