package com.FairShare.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.HashSet;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    private String description;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "paid_by", nullable = false)
    private User paidBy;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExpenseSplit> splits = new HashSet<>();
}