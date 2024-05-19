package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<DoctorDetailsDTO> registerDoctor(@RequestBody @Valid RegisterDoctorDTO registerDoctorDTO,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        var newDoctor = new Doctor(registerDoctorDTO);

        doctorRepository.save(newDoctor);

        var newDoctorDetails = new DoctorDetailsDTO(newDoctor);
        var resourceUri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(newDoctor.getId()).toUri();

        return ResponseEntity.created(resourceUri).body(newDoctorDetails);
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListItemDTO>> getDoctors(@PageableDefault(sort = "name", direction =
            Sort.Direction.ASC) Pageable paginationConfig) {
        var doctorsPage = doctorRepository.findAllByActiveTrue(paginationConfig).map(DoctorListItemDTO::new);

        return ResponseEntity.ok(doctorsPage);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<DoctorDetailsDTO> updateDoctor(@PathVariable Long id,
                                                         @RequestBody @Valid UpdateDoctorDTO updateDoctorDTO) {
        var doctor = doctorRepository.findById(id);

        if (doctor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var doctorDoc = doctor.get();

        doctorDoc.updateData(updateDoctorDTO);

        var updatedDoctorDetails = new DoctorDetailsDTO(doctorDoc);

        return ResponseEntity.ok(updatedDoctorDetails);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        var doctor = doctorRepository.findById(id);

        if (doctor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        doctor.get().virtualDeletion();

        return ResponseEntity.noContent().build();
    }
}
