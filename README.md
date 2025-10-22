# ThAmCo Order Fulfilment Microservice

> Originally developed as part of the Cloud Computing DevOps module in the Computer Science programme.

This project is part of the ThAmCo Order subsystem.
It fulfils its job as a microservice marking orders as fulfilled.

> ***Note:*** This is purely a backend API microservice, no pages are served.

# Controller:
## `/orders/fulfil/{order_id}` - Put
This path is a Put mapping since it calls a controller in the Update service which is a put mapping.
It calls the update service with the provided order ID. 

# Environment Variables:
## Fulfilment Specific:
`UPDATE_DOMAIN` The domain of the update service.
`UPDATE_PATH` The common path of the service.
`UPDATE_PATH_FULFIL` The rest of the path for use by the fulfil service.

`RETRIEVAL_DOMAIN` The domain of the retrieval service.
`RETRIEVAL_PATH` The common path of the retrieval service.
`RETRIEVAL_UNFULFILLED_PATH` The rest of the path for use by the fulfil service.

## Other:
### Testing:
NOTE: These are only used for testing purposes and should not be used in a production environment as they are not defined in the production `application.properties` file.<br>
`TEST_VAR` Used to test if the application is correctly reading environment variables. Should read as anything but "fallback" since fallback means failure. Fallback = `fallback`<br>
`FULFIL_PORT` Used for testing on a local machine. Fallback = `59003`<br>
Fallback means the default value should the environment variable not be set. If there is no mention of a fallback variable, there is no fallback value, and it could cause issues.