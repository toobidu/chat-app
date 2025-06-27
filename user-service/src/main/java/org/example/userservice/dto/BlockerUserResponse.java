package org.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockerUserResponse {
    private UUID blockerId;
    private UUID blockedId;
    private String reason;
    private LocalDateTime createdAt;
}