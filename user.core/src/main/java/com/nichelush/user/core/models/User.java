package com.nichelush.user.core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotEmpty(message="First Name is mandatory!")
    private String firstName;
    @NotEmpty(message="Last Name is mandatory!")
    private String lastName;
    @Email(message="Please provide a valid email address!")
    private String emailAddress;
    @NotNull(message = "Please provide valid account information!")
    private Account account;
}
