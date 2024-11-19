package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.domain.Record;
import ua.sevastianov.backtechproject.service.RecordService;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {
    private Map<Long, Record> records = new HashMap<>();
    private Long nextId = 1L;

    public Record createRecord(Record record) {
        record = record.toBuilder().id(nextId++).build();
        records.put(record.getId(), record);
        return record;
    }

    public Optional<Record> getRecord(Long id) {
        return Optional.ofNullable(records.get(id));
    }

    public List<Record> getRecordsByUser(Long userId) {
        return records.values().stream()
                .filter(record -> record.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Record> getRecordsByCategory(Long userId, Long categoryId) {
        return records.values().stream()
                .filter(record -> record.getUserId().equals(userId) && record.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }
    public List<Record> getRecordsByCategory(Long categoryId) {
        return records.values().stream()
                .filter(record -> record.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    public boolean deleteRecord(Long id) {
        return records.remove(id) != null;
    }
}
