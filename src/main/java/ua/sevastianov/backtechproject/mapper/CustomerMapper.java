package ua.sevastianov.backtechproject.mapper;

import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;
import ua.sevastianov.backtechproject.domain.customer.Customer;

public interface CustomerMapper {
    Customer toEntity(CustomerDTO customerDTO);
    CustomerDTO toEntryDTO(Customer customer);
}
