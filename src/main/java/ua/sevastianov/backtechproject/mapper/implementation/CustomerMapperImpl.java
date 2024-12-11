package ua.sevastianov.backtechproject.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.sevastianov.backtechproject.DTO.customer.CustomerDTO;
import ua.sevastianov.backtechproject.domain.customer.Customer;
import ua.sevastianov.backtechproject.mapper.CustomerMapper;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        return Customer.builder()
                .id(customerDTO.getId()) // Якщо id задається
                .username(customerDTO.getUsername())
                .build();
    }

    @Override
    public CustomerDTO toEntryDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerDTO.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .build();
    }
}
