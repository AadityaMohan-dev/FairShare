package com.FairShare.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupMemberRequest {
    private Long groupId;
    private Long userId;
}