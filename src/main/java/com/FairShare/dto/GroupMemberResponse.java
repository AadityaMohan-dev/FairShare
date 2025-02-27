package com.FairShare.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class GroupMemberResponse {
    private Long groupId;
    private Long userId;
    private LocalDateTime joinedAt;
}