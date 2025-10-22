package com.thamco.shop.order.fulfilment.model;

import java.util.List;

/**
 * A DTO that contains order IDs and a list of order item IDs part of that order.
 */
public class OrderWithItems
{
    private int orderId;

    private List<Integer> orderItemIds;

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public List<Integer> getOrderItemIds()
    {
        return orderItemIds;
    }

    public void setOrderItemIds(List<Integer> orderItemIds)
    {
        this.orderItemIds = orderItemIds;
    }
}
