package ua.sevastianov.backtechproject.service;

import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;

public interface AuthService {
    CustomerDTO register(CustomerDTO customerDTO);
    String login(CustomerDTO customerDTO);
}
