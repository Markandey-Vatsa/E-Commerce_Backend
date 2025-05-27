package com.e_commerce.ecommerce_backend.api.model;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
public class RegistrationBody {


    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    @Size(max = 255, message = "Username must not exceed 255 characters")
    private String username;


    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 32, message = "Password must be between 6 and 32 characters")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
            message = "Password must contain at least one letter and one number")
    private String password;


    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;





}
