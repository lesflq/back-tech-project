package ua.sevastianov.backtechproject.DTO.orderRecord;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class OrderRecordDTO {
    Long id;

    @NotNull(message = "User ID cannot be null")
    Long userId;

    @NotNull(message = "Category ID cannot be null")
    Long categoryId;

    @NotNull(message = "Timestamp cannot be null")
    LocalDateTime timestamp;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    Double amount;
}
