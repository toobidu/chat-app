package org.example.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {
    @NotBlank(message = "Please enter old password!")
    private String oldPassword;

    @NotBlank(message = "Please enter new password!")
    private String newPassword;

    @NotBlank(message = "Please enter confirm new password!")
    private String confirmNewPassword;
}