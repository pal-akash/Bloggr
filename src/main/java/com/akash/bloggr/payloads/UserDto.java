package com.akash.bloggr.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;

    @NotEmpty
    @Size(min = 4, message = "Username must have minimum of 4 characters")
    private String name;

    @Email(message = "Email address is invalid")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password length must be between 3 to 10")
    private String password;

    @NotEmpty
    private String about;
}
