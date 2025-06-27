package org.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyOTPResponse {
    private boolean success;
    private String message;
    private UUID userId; // Có thể dùng để trả về user nếu cần tiếp tục đăng nhập
}
