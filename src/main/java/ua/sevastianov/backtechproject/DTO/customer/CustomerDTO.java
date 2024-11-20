package ua.sevastianov.backtechproject.DTO.customer;

import lombok.*;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CustomerDTO {
    Long id;
    String name;
}
