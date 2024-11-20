package ua.sevastianov.backtechproject.domain.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import ua.sevastianov.backtechproject.domain.customer.Customer;

@Value
@Builder(toBuilder = true)
@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated(EnumType.STRING)
    CategoryType type; // Використання enum для type

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = true)
    Customer owner; // Може бути null, якщо це GLOBAL
}

