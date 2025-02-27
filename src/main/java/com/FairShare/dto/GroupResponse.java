package com.example.expensetracker.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class GroupResponse {
    private Long id;
    private String name;
    private String description;
    private Long createdBy; // User ID of the creator
    private Set<Long> memberIds; // User IDs of the members
    private LocalDateTime createdAt;
}