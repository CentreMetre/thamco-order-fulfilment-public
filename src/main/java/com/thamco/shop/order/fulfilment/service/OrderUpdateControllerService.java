package com.thamco.shop.order.fulfilment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * Implementation of {@link OrderUpdateService}
 */
@Service
public class OrderUpdateControllerService implements OrderUpdateService
{
    public static final Logger logger = Logger.getLogger(OrderUpdateControllerService.class.getName());

    @Value("${order.update.domain}")
    private String orderUpdateDomain;

    @Value("${order.update.path}")
    private String orderUpdatePath;

    @Value("${order.update.path.fulfil}")
    private String orderUpdatePathFulfil;

    private final RestTemplate restTemplate;

    public OrderUpdateControllerService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public String requestMarkOrderAsFulfilled(int orderId)
    {
        logger.info("Request to mark order '" + orderId + "' as fulfilled received");

        String url = orderUpdateDomain + "/" + orderUpdatePath +  "/" + orderUpdatePathFulfil + "/" + orderId;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Integer> requestEntity = new HttpEntity<>(orderId, headers);

        ResponseEntity<Void> response = restTemplate.exchange
        (
                url,
                HttpMethod.PUT,
                requestEntity,
                Void.class
        );

        return response.getStatusCode().toString();
    }
}
