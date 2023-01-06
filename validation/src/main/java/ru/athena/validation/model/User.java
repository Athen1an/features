package ru.athena.validation.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Valid // if we want to validate inner object, we should add @Valid annotation
    private Address address;
}
