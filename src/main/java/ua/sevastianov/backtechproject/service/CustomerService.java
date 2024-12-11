package ua.sevastianov.backtechproject.service;

import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
//    CustomerDTO registeCustomer(CustomerDTO customerDTO);

    Optional<CustomerDTO> getCustomer(Long id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(Long id);
}

