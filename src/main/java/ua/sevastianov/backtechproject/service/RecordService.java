package ua.sevastianov.backtechproject.service;
import ua.sevastianov.backtechproject.domain.Record;
import java.util.List;
import java.util.Optional;

public interface RecordService {
    Optional<Record> getRecord(Long id);
    Record createRecord(Record record);
    List<Record> getRecordsByUser(Long userId);
    List<Record> getRecordsByCategory(Long userId, Long categoryId);
    List<Record> getRecordsByCategory(Long categoryId);
    boolean deleteRecord(Long id);
}
