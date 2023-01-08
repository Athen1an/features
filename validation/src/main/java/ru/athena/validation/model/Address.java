package ru.athena.validation.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.athena.validation.group.WithAddressValidationGroup;

@Data
@Accessors(chain = true)
public class Address {

    @NotBlank(groups = WithAddressValidationGroup.class)
    private String postCode;

    @NotBlank(groups = WithAddressValidationGroup.class)
    private String fullAddress;
}
