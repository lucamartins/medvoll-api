package med.voll.api.domain.doctor;

import jakarta.validation.Valid;
import med.voll.api.domain.address.RegisterAddressDTO;

public record UpdateDoctorDTO(
        String name,
        String phone,
        @Valid RegisterAddressDTO address) {
}
