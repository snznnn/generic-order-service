package com.snzn.project.order.service.external.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateResponse {

    @Valid
    @NotEmpty
    private List<OrderEntryPriceModel> entryPriceList;

}
