package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        var loginToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.email(), loginRequestDTO.password());

        var authResult = authenticationManager.authenticate(loginToken);

        return ResponseEntity.ok().build();
    }
}
