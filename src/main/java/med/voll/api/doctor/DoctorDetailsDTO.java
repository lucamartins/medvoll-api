package med.voll.api.doctor;

import med.voll.api.address.Address;

public record DoctorDetailsDTO(
        Long id,
        String name,
        String email,
        String phone,
        String crm,
        DoctorSpecialty specialty,
        Address address
) {
    public DoctorDetailsDTO(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                doctor.getAddress()
        );
    }
}
