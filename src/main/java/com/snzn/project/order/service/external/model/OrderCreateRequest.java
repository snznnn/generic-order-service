package com.snzn.project.order.service.external.model;

import com.snzn.project.order.controller.model.OrderEntryQuantityModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {

    private String orderNo;

    private List<OrderEntryQuantityModel> entryQuantityList;

}
