package org.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String avatarUrl;
    private String status;
    private Boolean isOnline;
    private LocalDateTime lastOnline;
    private LocalDateTime createdAt;
}