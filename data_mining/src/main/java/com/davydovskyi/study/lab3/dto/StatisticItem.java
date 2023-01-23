package com.davydovskyi.study.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticItem {
    private int year;
    private BigDecimal capital;
    private int aliveClients;
    private int diedClients;
    private BigDecimal incomePayments;
    private BigDecimal outcomePayments;
}
