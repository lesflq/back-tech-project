package ua.sevastianov.backtechproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
@Entity
@Table(name = "record")
@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    Customer user;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;

    LocalDateTime timestamp;
    Double amount;
}
