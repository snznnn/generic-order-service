package com.snzn.project.order.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {

    private String category;

    private String definition;

    private String brand;

    private String model;

    private Integer quantity;

    private BigDecimal price;

}
