package med.voll.api.doctor;

public record DoctorListItemDTO(String name, String email, String crm, DoctorSpecialty specialty) {
    public DoctorListItemDTO(Doctor doctor) {
        this(
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getSpecialty()
        );
    }
}
