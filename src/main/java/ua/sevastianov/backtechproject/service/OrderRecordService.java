package ua.sevastianov.backtechproject.service;
import ua.sevastianov.backtechproject.DTO.orderRecord.OrderRecordDTO;

import java.util.List;
import java.util.Optional;

public interface OrderRecordService {
    Optional<OrderRecordDTO> getRecord(Long id);
    OrderRecordDTO createRecord(OrderRecordDTO orderRecordDTO);
    List<OrderRecordDTO> getRecordsByUser(Long userId);
    List<OrderRecordDTO> getRecordsByBothParams(Long userId, Long categoryId);
    List<OrderRecordDTO> getRecordsByCategory(Long categoryId);
    boolean deleteRecord(Long id);
}
