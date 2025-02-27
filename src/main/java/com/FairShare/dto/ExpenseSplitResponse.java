package com.FairShare.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseSplitResponse {
    private Long expenseId;
    private Long userId;
    private Double share;
}