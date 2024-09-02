package com.nathaliamello.gitflowdemo.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserDTO {

    @NotNull(message = "The name is required")
    @Schema(description = "User's full name", example = "John Doe")
    private String name;

    @NotNull(message = "The email is required")
    @Schema(description = "User's email", example = "johndoe@mail.com")
    private String email;

    @NotNull(message = "The date of birth is required")
    @Past(message = "The date of birth must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "User's date of birth", example = "1990-01-01")
    private LocalDate birthdate;

    @NotNull(message = "The CPF is required")
    @Schema(description = "User's Taxpayer Identification Number (CPF)", example = "10020030099")
    private String cpf;

    public CreateUserDTO() {
    }
}
