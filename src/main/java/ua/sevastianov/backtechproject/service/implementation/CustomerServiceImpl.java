package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;
import ua.sevastianov.backtechproject.domain.customer.Customer;
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

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        System.out.println("Received CustomerDTO: " + customerDTO.getName());
        Customer customer = customerMapper.toEntity(customerDTO);
        System.out.println("Mapped Customer: " + customer.getName());
        Customer savedCustomer = customerRepository.save(customer);
        System.out.println("Saved Customer: " + savedCustomer.getName());
        return customerMapper.toEntryDTO(savedCustomer);
    }
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

