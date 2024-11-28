package com.snzn.project.order.service;

import com.snzn.project.order.controller.model.OrderCompleteRequest;
import com.snzn.project.order.controller.model.OrderSubmitRequest;
import com.snzn.project.order.controller.model.OrderSubmitResponse;
import com.snzn.project.order.repository.OrderDetailRepository;
import com.snzn.project.order.repository.OrderRepository;
import com.snzn.project.order.repository.entity.OrderDetail;
import com.snzn.project.order.repository.entity.OrderEntity;
import com.snzn.project.order.repository.entity.OrderStatus;
import com.snzn.project.order.service.external.StockServiceClient;
import com.snzn.project.order.service.external.model.OrderCreateRequest;
import com.snzn.project.order.service.external.model.OrderCreateResponse;
import com.snzn.project.order.service.external.model.OrderEntryPriceModel;
import com.snzn.project.order.service.external.model.OrderUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final StockServiceClient client;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderSubmitResponse submit(String customerNo, OrderSubmitRequest request) {
        String orderNo = UUID.randomUUID().toString();
        OrderCreateResponse response = client.orderCreate(new OrderCreateRequest(orderNo, request.getEntryQuantityList()));

        OrderEntity order = new OrderEntity(orderNo, customerNo, OrderStatus.IN_PROGRESS, null);
        List<OrderDetail> detailList = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderEntryPriceModel priceModel : response.getEntryPriceList()) {
            OrderDetail orderDetail = new OrderDetail(
                    order,
                    priceModel.getCategory(),
                    priceModel.getDefinition(),
                    priceModel.getBrand(),
                    priceModel.getModel(),
                    priceModel.getQuantity(),
                    priceModel.getPrice()
            );
            detailList.add(orderDetail);
            BigDecimal price = priceModel.getPrice().multiply(BigDecimal.valueOf(priceModel.getQuantity()));
            totalPrice = totalPrice.add(price);
        }
        order.setTotalPrice(totalPrice);

        orderRepository.save(order);
        orderDetailRepository.saveAll(detailList);

        return new OrderSubmitResponse(orderNo, totalPrice);
    }

    public void complete(OrderCompleteRequest request) {
        if (request.getMockPaymentTool().equals("Fail")) {
            orderRepository.updateStatusByOrderNo(OrderStatus.CANCELED, request.getOrderNo());
            try {
                client.orderCancel(new OrderUpdateRequest(request.getOrderNo()));
            } catch (Exception e) {
                log.error("Error log;", e);
            }
        } else {
            client.orderComplete(new OrderUpdateRequest(request.getOrderNo()));
            orderRepository.updateStatusByOrderNo(OrderStatus.COMPLETED, request.getOrderNo());
        }
    }

}
