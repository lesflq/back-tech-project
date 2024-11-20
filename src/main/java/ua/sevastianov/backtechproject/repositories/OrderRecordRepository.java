package ua.sevastianov.backtechproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.sevastianov.backtechproject.domain.orderRecord.OrderRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRecordRepository extends JpaRepository<OrderRecord, Long> {
    List<OrderRecord> findByUserId(Long userId);
    List<OrderRecord> findByCategoryId(Long categoryId);
    List<OrderRecord> findByUserIdAndCategoryId(Long userId, Long categoryId);
}

