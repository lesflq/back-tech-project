package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.domain.Customer;
import ua.sevastianov.backtechproject.repositories.CustomerRepository;
import ua.sevastianov.backtechproject.service.CustomerService;


import java.util.*;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
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

