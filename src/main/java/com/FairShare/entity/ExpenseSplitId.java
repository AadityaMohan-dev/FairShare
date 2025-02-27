package com.FairShare.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class ExpenseSplitId implements Serializable {
    private Long expenseId;
    private Long userId;
}