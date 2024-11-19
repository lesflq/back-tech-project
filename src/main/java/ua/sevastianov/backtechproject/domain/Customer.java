package ua.sevastianov.backtechproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Value
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
}
