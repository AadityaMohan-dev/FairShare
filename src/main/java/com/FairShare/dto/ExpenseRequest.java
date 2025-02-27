package com.FairShare.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.Map;

@Data
@Builder
public class ExpenseRequest {
    private Double amount;
    private String description;
    private LocalDate date;
    private Long paidBy; // User ID of the payer
    private Long groupId; // Group ID where the expense is added
    private Map<Long, Double> splits; // User ID -> Share amount
}