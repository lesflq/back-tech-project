package ua.sevastianov.backtechproject.web;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;
import ua.sevastianov.backtechproject.domain.customer.Customer;
import ua.sevastianov.backtechproject.repositories.CustomerRepository;
import ua.sevastianov.backtechproject.service.implementation.AuthServiceImpl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> register(@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseEntity.ok(authService.register(customerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody CustomerDTO customerDTO) {
        String token = authService.login(customerDTO);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

}
