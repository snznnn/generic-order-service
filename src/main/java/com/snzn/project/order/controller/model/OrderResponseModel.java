package com.snzn.project.order.controller.model;

import com.snzn.project.order.repository.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseModel {

    private String orderNo;

    private String customerNo;

    private OrderStatus status;

    private BigDecimal totalPrice;

    private List<OrderDetailModel> detailModelList;

}
