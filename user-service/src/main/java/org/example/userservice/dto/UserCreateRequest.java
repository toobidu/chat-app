package org.example.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    private String firstName;
    private String lastName;

    @Pattern(
            regexp = "^(0)(32|33|34|35|36|37|38|39|96|97|98|70|76|77|78|79|89|90|93)[0-9]{7}$",
            message = "Invalid phone number"
    )
    private String phoneNumber;

    @NotBlank(message = "Email is not blank")
    @Email(message = "Invalid email!")
    private String email;
    private String address;
}