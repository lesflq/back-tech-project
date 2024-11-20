package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.DTO.orderRecord.OrderRecordDTO;
import ua.sevastianov.backtechproject.domain.orderRecord.OrderRecord;
import ua.sevastianov.backtechproject.mapper.OrderRecordMapper;
import ua.sevastianov.backtechproject.repositories.OrderRecordRepository;
import ua.sevastianov.backtechproject.service.OrderRecordService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderRecordServiceImpl implements OrderRecordService {
    private final OrderRecordRepository orderRecordRepository;
    private final OrderRecordMapper orderRecordMapper;

    public OrderRecordServiceImpl(OrderRecordRepository orderRecordRepository, OrderRecordMapper orderRecordMapper) {
        this.orderRecordRepository = orderRecordRepository;
        this.orderRecordMapper = orderRecordMapper;
    }

    @Override
    public OrderRecordDTO createRecord(OrderRecordDTO orderRecordDTO) {
        OrderRecord orderRecord = orderRecordMapper.toEntity(orderRecordDTO);
        OrderRecord savedOrderRecord = orderRecordRepository.save(orderRecord);
        return orderRecordMapper.toEntryDTO(savedOrderRecord);
    }

    @Override
    public Optional<OrderRecordDTO> getRecord(Long id) {
        return orderRecordRepository.findById(id).map(orderRecordMapper::toEntryDTO);
    }

    @Override
    public List<OrderRecordDTO> getRecordsByUser(Long userId) {
        return orderRecordRepository.findByUserId(userId)
                .stream()
                .map(orderRecordMapper::toEntryDTO)
                .toList();
    }

    @Override
    public List<OrderRecordDTO> getRecordsByCategory(Long categoryId) {
        return orderRecordRepository.findByCategoryId(categoryId)
                .stream()
                .map(orderRecordMapper::toEntryDTO)
                .toList();
    }

    @Override
    public List<OrderRecordDTO> getRecordsByBothParams(Long userId, Long categoryId) {
        return orderRecordRepository.findByUserIdAndCategoryId(userId, categoryId)
                .stream()
                .map(orderRecordMapper::toEntryDTO)
                .toList();
    }

    @Override
    public boolean deleteRecord(Long id) {
        if (orderRecordRepository.existsById(id)) {
            orderRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

