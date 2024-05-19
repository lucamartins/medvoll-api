package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public void registerDoctor(@RequestBody @Valid RegisterDoctorDTO registerDoctorDTO) {
        doctorRepository.save(new Doctor(registerDoctorDTO));
    }

    @GetMapping
    public Page<DoctorListItemDTO> getDoctors(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable paginationConfig) {
        var doctors = doctorRepository.findAll(paginationConfig);

        return doctors.map(DoctorListItemDTO::new);
    }

    @PatchMapping("/{id}")
    @Transactional
    public void updateDoctor(@PathVariable Long id, @RequestBody @Valid UpdateDoctorDTO updateDoctorDTO) {
        var doctor = doctorRepository.findById(id);

        doctor.ifPresent(value -> value.updateData(updateDoctorDTO));
    }
}
