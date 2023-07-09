package com.springbootrestfullwebservices.springbootrestfullwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Schema(
        description = "User DTO Class"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID id;
    @Schema(
            description = "First Name"
    )
    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;
    @Schema(
            description = "Last Name"
    )
    @NotEmpty(message = "LastName should not be empty")
    private String lastName;
    @Schema(
            description = "Mail Address"
    )
    @Email(message = "Email address should be valid")
    @NotEmpty(message = "mail should not be empty")
    private String mail;
    @Schema(
            description = "Address Of the User"
    )
    @NotEmpty(message = "address should not be empty")
    private String address;
}
