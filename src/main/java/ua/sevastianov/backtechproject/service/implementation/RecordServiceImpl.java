package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.domain.Record;
import ua.sevastianov.backtechproject.repositories.RecordRepository;
import ua.sevastianov.backtechproject.service.RecordService;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;

    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public Optional<Record> getRecord(Long id) {
        return recordRepository.findById(id);
    }

    @Override
    public List<Record> getRecordsByUser(Long userId) {
        return recordRepository.findByUserId(userId);
    }

    @Override
    public List<Record> getRecordsByCategory(Long categoryId) {
        return recordRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Record> getRecordsByCategory(Long userId, Long categoryId) {
        return recordRepository.findByUserIdAndCategoryId(userId, categoryId);
    }

    @Override
    public boolean deleteRecord(Long id) {
        if (recordRepository.existsById(id)) {
            recordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

