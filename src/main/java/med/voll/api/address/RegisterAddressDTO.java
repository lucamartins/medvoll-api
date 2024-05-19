package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;

public record RegisterAddressDTO(
        @NotBlank
        String street,
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String zipCode
) { }
