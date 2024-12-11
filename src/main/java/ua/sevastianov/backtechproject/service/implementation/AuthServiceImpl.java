package ua.sevastianov.backtechproject.service.implementation;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;
import ua.sevastianov.backtechproject.domain.customer.Customer;
import ua.sevastianov.backtechproject.exception.AuthenticationException;
import ua.sevastianov.backtechproject.mapper.CustomerMapper;
import ua.sevastianov.backtechproject.repositories.CustomerRepository;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class AuthServiceImpl {

    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final CustomerMapper customerMapper;
    private final String JWT_SECRET = "ВашДовгийСекретнийКлючЩонайменше64Символи";
    private final long jwtExpirationMs = 86400000; // 1 день у мілісекундах


    public AuthServiceImpl(CustomerRepository customerRepository, AuthenticationManager authenticationManager,
                           PasswordEncoder passwordEncoder, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO register(CustomerDTO customerDTO) {
        if (customerRepository.existsByUsername(customerDTO.getUsername())) {
            throw new IllegalArgumentException("User already exists!");
        }

        Customer customer = customerMapper.toEntity(customerDTO);
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toEntryDTO(savedCustomer);
    }

    public String login(CustomerDTO customerDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            customerDTO.getUsername(),
                            customerDTO.getPassword()
                    )
            );

            Customer customer = customerRepository.findByUsername(customerDTO.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            return generateToken(customer.getUsername());
        } catch (BadCredentialsException ex) {
            throw new AuthenticationException("Invalid username or password");
        }
    }

    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("authorities", List.of("ROLE_USER")) // Використовуйте список
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(JWT_SECRET.getBytes()))
                .compact();
    }

}
