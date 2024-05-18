package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    private String zipCode;

    public Address(RegisterAddressDTO registerAddressDTO) {
        this.street = registerAddressDTO.street();
        this.number = registerAddressDTO.number();
        this.complement = registerAddressDTO.complement();
        this.neighborhood = registerAddressDTO.neighborhood();
        this.city = registerAddressDTO.city();
        this.state = registerAddressDTO.state();
        this.zipCode = registerAddressDTO.zipCode();
    }
}
