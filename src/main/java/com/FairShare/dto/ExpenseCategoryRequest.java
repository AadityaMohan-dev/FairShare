package com.FairShare.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseCategoryRequest {
    private String name;
    private String description;
}