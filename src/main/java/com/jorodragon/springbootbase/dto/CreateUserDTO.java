package com.jorodragon.springbootbase.dto;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(min = 4, max = 20, message = "Pasword must be between 4 and 20 characters")
    private String password;

    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    private String name;

    @Pattern(regexp="(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    private String phone;

    @Valid
    @URL(regexp="(https?:\\/\\/.*)", message="Avatar must be an url image")
    private String avatar;
}
