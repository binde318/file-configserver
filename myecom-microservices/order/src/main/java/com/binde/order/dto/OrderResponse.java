package com.binde.order.dto;


import com.binde.order.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private BigDecimal totalAmount;
    private List<OrderItemDTo> items;
    private OrderStatus status;
    private LocalDateTime createdAt;

//    public OrderResponse(Long id, BigDecimal totalAmount, List<OrderItemDTo> items,OrderStatus status, LocalDateTime createdAt) {
//        this.id = id;
//        this.totalAmount = totalAmount;
//        this.items = items;
//        this.status = status;
//        this.createdAt = createdAt;
//
//    }
}
