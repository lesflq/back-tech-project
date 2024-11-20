package ua.sevastianov.backtechproject.DTO.orderRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import ua.sevastianov.backtechproject.domain.category.Category;
import ua.sevastianov.backtechproject.domain.customer.Customer;

import java.time.LocalDateTime;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class OrderRecordDTO {
    Long id;
    Long userId;
    Long categoryId;
    LocalDateTime timestamp;
    Double amount;
}
