package com.nichelush.user.core.models;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "accounts")
public class Account {
    @Size(min = 2, message = "Username must have at least 2 characters")
    private String username;
    @Size(min = 7, message = "The password should have at least 7 characters")
    private String password;
    @NotNull(message = "Please specify at least ONE role")
    private List<Role> roles;

}
