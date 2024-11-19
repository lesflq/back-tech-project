package ua.sevastianov.backtechproject.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
@Value
@Builder(toBuilder = true)
public class Record {
    Long id;
    Long userId;
    Long categoryId;
    LocalDateTime timestamp;
    Double amount;

}
