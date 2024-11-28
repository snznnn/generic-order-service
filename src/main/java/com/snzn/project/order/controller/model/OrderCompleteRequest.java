package com.snzn.project.order.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCompleteRequest {

    @NotBlank
    private String orderNo;

    @NotBlank
    private String mockPaymentTool;

}
