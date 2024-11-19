package ua.sevastianov.backtechproject.service;

import ua.sevastianov.backtechproject.domain.Category;
import ua.sevastianov.backtechproject.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Optional<Customer> getCustomer(Long id);
    List<Customer> getAllCustomers();
    boolean deleteCustomer(Long id);
}
