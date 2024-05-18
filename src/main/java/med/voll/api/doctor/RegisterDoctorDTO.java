package med.voll.api.doctor;

import med.voll.api.address.RegisterAddressDTO;

public record RegisterDoctorDTO(String name, String email, String crm, DoctorSpecialty specialty, RegisterAddressDTO registerAddressDTO) { }
