package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.domain.Customer;
import ua.sevastianov.backtechproject.service.CustomerService;


import java.util.*;
@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<Long, Customer> customers = new HashMap<>();
    private Long nextId = 1L;

    public Customer createCustomer(Customer customer) {
        customer = customer.toBuilder().id(nextId++).build();
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Optional<Customer> getCustomer(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public boolean deleteCustomer(Long id) {
        return customers.remove(id) != null;
    }
}
