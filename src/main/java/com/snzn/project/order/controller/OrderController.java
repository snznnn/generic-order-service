package com.snzn.project.order.controller;

import com.snzn.project.order.controller.model.OrderCompleteRequest;
import com.snzn.project.order.controller.model.OrderSubmitRequest;
import com.snzn.project.order.service.OrderService;
import com.snzn.project.order.controller.model.OrderSubmitResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderService service;

    @PostMapping("/submit")
    public ResponseEntity<OrderSubmitResponse> submit(@RequestHeader("customer-no") String customerNo,
                                                      @RequestBody @Valid OrderSubmitRequest request) {
        return new ResponseEntity<>(service.submit(customerNo, request), CREATED);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody @Valid OrderCompleteRequest request) {
        service.complete(request);
        return new ResponseEntity<>(OK);
    }




}
