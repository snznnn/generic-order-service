package com.snzn.project.order.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn
    private OrderEntity orderEntity;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String definition;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer quantity;

    @DecimalMax(value = "1000000.0", inclusive = false)
    @DecimalMin(value = "1.0")
    @Column(nullable = false)
    private BigDecimal price;

}
