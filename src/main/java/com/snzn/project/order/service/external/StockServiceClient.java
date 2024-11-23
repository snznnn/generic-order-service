package com.snzn.project.order.service.external;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "stock-service-client", url = "http://localhost:8082")
public interface StockServiceClient {

}
