package med.voll.api.doctor;

import jakarta.validation.Valid;
import med.voll.api.address.RegisterAddressDTO;

public record UpdateDoctorDTO(
        String name,
        String phone,
        @Valid RegisterAddressDTO address) {
}
