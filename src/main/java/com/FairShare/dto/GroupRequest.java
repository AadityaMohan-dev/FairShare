package com.FairShare.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class GroupRequest {
    private String name;
    private String description;
    private Long createdBy; // User ID of the creator
    private Set<Long> memberIds; // User IDs of the members
}