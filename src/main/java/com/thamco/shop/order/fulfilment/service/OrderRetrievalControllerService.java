package com.thamco.shop.order.fulfilment.service;

import com.thamco.shop.order.fulfilment.model.OrderWithItems;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.logging.Logger;

@Service
public class OrderRetrievalControllerService implements OrderRetrievalService
{
    public static final Logger logger = Logger.getLogger(OrderRetrievalControllerService.class.getName());


    private final RestTemplate restTemplate;

    @Value("${order.retrieval.domain}")
    private String orderRetrieveUrl;

    @Value("${order.retrieval.path}")
    private String orderRetrievePath;

    @Value("${order.retrieval.path.unfulfilled}")
    private String orderRetrieveUnfulfilledPath;

    public OrderRetrievalControllerService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public Iterable<OrderWithItems> getUnfulfilledOrdersWithItems()
    {
        String url = orderRetrieveUrl + "/" + orderRetrievePath + "/" + orderRetrieveUnfulfilledPath;

        ResponseEntity<OrderWithItems[]> response = restTemplate.getForEntity(url, OrderWithItems[].class);

        logger.info("Response code: " + response.getStatusCode().toString());

        Iterable<OrderWithItems> ordersWithItems = Arrays.asList(response.getBody());

        return ordersWithItems;
    }
}
