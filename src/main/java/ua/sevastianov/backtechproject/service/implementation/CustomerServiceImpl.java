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

