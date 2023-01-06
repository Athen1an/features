package ru.athena.validation.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {

    @NotBlank
    private String postCode;

    @NotBlank
    private String fullAddress;
}
