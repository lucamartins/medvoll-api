package med.voll.api.controller;

import med.voll.api.doctor.RegisterDoctorDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @PostMapping
    void registerDoctor(@RequestBody RegisterDoctorDTO registerDoctorDTO) {
        System.out.println("Doctor registering request " + registerDoctorDTO);
    }
}
