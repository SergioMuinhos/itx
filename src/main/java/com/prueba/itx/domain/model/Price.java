package com.prueba.itx.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Price {
    private Long productId;
    private Long chainId;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private String currency;
}
