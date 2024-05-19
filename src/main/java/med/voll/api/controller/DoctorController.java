package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorListItemDTO;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.RegisterDoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    final private DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostMapping
    @Transactional
    void registerDoctor(@RequestBody @Valid RegisterDoctorDTO registerDoctorDTO) {
        doctorRepository.save(new Doctor(registerDoctorDTO));
    }

    @GetMapping
    List<DoctorListItemDTO> getDoctors() {
        var doctors = doctorRepository.findAll();

        return doctors
                .stream()
                .map(d -> new DoctorListItemDTO(d.getName(), d.getEmail(), d.getCrm(), d.getSpecialty()))
                .toList();
    }
}
