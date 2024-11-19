package ua.sevastianov.backtechproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sevastianov.backtechproject.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

