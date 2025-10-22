package com.thamco.shop.order.fulfilment.web;

import com.thamco.shop.order.fulfilment.model.OrderWithItems;
import com.thamco.shop.order.fulfilment.service.OrderUpdateService;
import com.thamco.shop.order.fulfilment.service.OrderRetrievalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the fulfillment service
 */
@RestController
public class FulfilmentController
{
    private final OrderUpdateService orderUpdateService;
    private final OrderRetrievalService orderRetrievalService;

    public FulfilmentController(OrderUpdateService orderUpdateService, OrderRetrievalService orderRetrievalService)
    {
        this.orderUpdateService = orderUpdateService;
        this.orderRetrievalService = orderRetrievalService;
    }

    //curl -X PUT http://localhost:58003/orders/fulfil/41
    @PutMapping("/orders/fulfil/{order_id}")
    public ResponseEntity<String> requestMarkOrderAsFulfilled(@PathVariable("order_id") int orderId)
    {
        String response = orderUpdateService.requestMarkOrderAsFulfilled(orderId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/orders/fulfil/unfulfilled/")
    public Iterable<OrderWithItems> getUnfulfilledOrder()
    {
        return orderRetrievalService.getUnfulfilledOrdersWithItems();
    }
}
