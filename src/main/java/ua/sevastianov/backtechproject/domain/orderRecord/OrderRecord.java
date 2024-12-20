package ua.sevastianov.backtechproject.domain.orderRecord;

import jakarta.persistence.*;
import lombok.*;
import ua.sevastianov.backtechproject.domain.category.Category;
import ua.sevastianov.backtechproject.domain.customer.Customer;

import java.time.LocalDateTime;
@Entity
@Table(name = "record")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class OrderRecord {
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
