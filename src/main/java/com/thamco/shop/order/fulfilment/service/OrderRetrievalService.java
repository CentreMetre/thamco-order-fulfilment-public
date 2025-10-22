package com.thamco.shop.order.fulfilment.service;

import com.thamco.shop.order.fulfilment.model.OrderWithItems;

import java.util.List;

/**
 * Interface for getting a list of unfulfilled from the DB.
 */
public interface OrderRetrievalService
{
    /**
     * Gets a list of orders with their items.
     * @return A {@code List} of {@link OrderWithItems} objects
     */
    Iterable<OrderWithItems> getUnfulfilledOrdersWithItems();
}
