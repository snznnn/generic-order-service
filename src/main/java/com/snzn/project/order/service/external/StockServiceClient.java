package com.snzn.project.order.service.external;

import com.snzn.project.order.service.external.model.OrderCreateRequest;
import com.snzn.project.order.service.external.model.OrderCreateResponse;
import com.snzn.project.order.service.external.model.OrderUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "stock-service-client", url = "${feign.url}")
public interface StockServiceClient {

    @Valid
    @PostMapping("/order/create")
    OrderCreateResponse orderCreate(OrderCreateRequest request);

    @PostMapping("/order/complete")
    void orderComplete(OrderUpdateRequest request);

    @PostMapping("/order/cancel")
    void orderCancel(OrderUpdateRequest request);

}
