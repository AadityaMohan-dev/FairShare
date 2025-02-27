package com.FairShare.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ExpenseSplit")
public class ExpenseSplit {
    @EmbeddedId
    private ExpenseSplitId id;

    @ManyToOne
    @MapsId("expenseId")
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Double share;
}