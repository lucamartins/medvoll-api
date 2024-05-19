package med.voll.api.doctor;

public record DoctorListItemDTO(Long id, String name, String email, String crm, DoctorSpecialty specialty) {
    public DoctorListItemDTO(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getSpecialty()
        );
    }
}
