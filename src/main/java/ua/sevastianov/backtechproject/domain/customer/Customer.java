package ua.sevastianov.backtechproject.domain.customer;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "customer")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

}
