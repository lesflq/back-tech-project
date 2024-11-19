package ua.sevastianov.backtechproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.sevastianov.backtechproject.domain.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserId(Long userId);
    List<Record> findByCategoryId(Long categoryId);
    List<Record> findByUserIdAndCategoryId(Long userId, Long categoryId);
}

