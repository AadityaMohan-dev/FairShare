package com.FairShare.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String username;
    private String email;
    private String password;
}