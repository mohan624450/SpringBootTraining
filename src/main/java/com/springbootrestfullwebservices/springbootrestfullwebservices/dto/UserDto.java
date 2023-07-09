package com.springbootrestfullwebservices.springbootrestfullwebservices.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID id;
    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;
    @NotEmpty(message = "LastName should not be empty")
    private String lastName;
    @Email(message = "Email address should be valid")
    @NotEmpty(message = "mail should not be empty")
    private String mail;
    @NotEmpty(message = "address should not be empty")
    private String address;
}
