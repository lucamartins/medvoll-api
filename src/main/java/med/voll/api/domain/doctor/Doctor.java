package med.voll.api.domain.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;

@Entity
@Table(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private DoctorSpecialty specialty;

    @Embedded
    private Address address;

    private Boolean active;

    public Doctor(RegisterDoctorDTO registerDoctorDTO) {
        this.active = true;
        this.name = registerDoctorDTO.name();
        this.email = registerDoctorDTO.email();
        this.phone = registerDoctorDTO.phone();
        this.crm = registerDoctorDTO.crm();
        this.specialty = registerDoctorDTO.specialty();
        this.address = new Address(registerDoctorDTO.address());
    }

    public void updateData(UpdateDoctorDTO updateDoctorDTO) {
        if (updateDoctorDTO.name() != null) {
            this.name = updateDoctorDTO.name();
        }

        if (updateDoctorDTO.address() != null) {
            this.address = new Address(updateDoctorDTO.address());
        }

        if (updateDoctorDTO.phone() != null) {
            this.phone = updateDoctorDTO.phone();
        }
    }

    public void virtualDeletion() {
        this.active = false;
    }
}
