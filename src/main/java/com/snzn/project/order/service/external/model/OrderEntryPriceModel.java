package com.snzn.project.order.service.external.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntryPriceModel {

    @NotBlank
    private String category;

    @NotBlank
    private String definition;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal price;

}
