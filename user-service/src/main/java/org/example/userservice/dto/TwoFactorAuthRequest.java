package org.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwoFactorAuthRequest {
    private UUID userId;
    private String methodProvider;
    private String secret;
    private String backupCode;
    private Boolean enabled;
}