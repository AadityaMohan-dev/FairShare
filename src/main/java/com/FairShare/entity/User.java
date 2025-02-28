package com.FairShare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> createdGroups = new HashSet<>();

    @OneToMany(mappedBy = "paidBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Expense> expensesPaid = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExpenseSplit> expenseSplits = new HashSet<>();

    @ManyToMany(mappedBy = "members")
    private Set<Group> groups = new HashSet<>();
}