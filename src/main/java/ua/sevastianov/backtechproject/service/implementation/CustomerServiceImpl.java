package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;

import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;
import ua.sevastianov.backtechproject.mapper.CustomerMapper;
import ua.sevastianov.backtechproject.repositories.CustomerRepository;
import ua.sevastianov.backtechproject.service.CustomerService;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

//    public CustomerDTO registeCustomer(CustomerDTO customerDTO) {
//        // Перевірка чи існує користувач із таким username
//        if (customerRepository.existsByUsername(customerDTO.getUsername())) {
//            throw new IllegalArgumentException("User already exists!");
//        }
//
//        Customer customer = customerMapper.toEntity(customerDTO);
//        Customer savedCustomer = customerRepository.save(customer);
//        return customerMapper.toEntryDTO(savedCustomer);
//    }
//
//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody CustomerDTO customerDTO) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(customerDTO.getUsername(), customerDTO.getPassword())
//        );
//
//        Customer user = (Customer) authentication.getPrincipal();
//        String token = Jwts.builder()
//                .setSubject(user.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 день
//                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//                .compact();
//
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//        return response;
//    }

    @Override
    public Optional<CustomerDTO> getCustomer(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toEntryDTO);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toEntryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

