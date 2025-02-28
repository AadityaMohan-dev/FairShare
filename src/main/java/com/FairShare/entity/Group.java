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
@Table(name = "Group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToMany
    @JoinTable(
            name = "GroupMember",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> members = new HashSet<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Expense> expenses = new HashSet<>();
}