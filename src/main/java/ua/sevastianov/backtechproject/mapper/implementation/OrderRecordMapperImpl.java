package ua.sevastianov.backtechproject.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.sevastianov.backtechproject.DTO.orderRecord.OrderRecordDTO;
import ua.sevastianov.backtechproject.domain.category.Category;
import ua.sevastianov.backtechproject.domain.customer.Customer;
import ua.sevastianov.backtechproject.domain.orderRecord.OrderRecord;
import ua.sevastianov.backtechproject.mapper.OrderRecordMapper;

@Component
public class OrderRecordMapperImpl implements OrderRecordMapper {
    @Override
    public OrderRecordDTO toEntryDTO(OrderRecord entity) {
        return OrderRecordDTO.builder()
                .id(entity.getId())
                .userId(entity.getUser() != null ? entity.getUser().getId() : null)
                .categoryId(entity.getCategory() != null ? entity.getCategory().getId() : null)
                .timestamp(entity.getTimestamp())
                .amount(entity.getAmount())
                .build();
    }

    @Override
    public OrderRecord toEntity(OrderRecordDTO dto) {
        return OrderRecord.builder()
                .id(dto.getId())
                .user(dto.getUserId() != null ? Customer.builder().id(dto.getUserId()).build() : null)
                .category(dto.getCategoryId() != null ? Category.builder().id(dto.getCategoryId()).build() : null)
                .timestamp(dto.getTimestamp())
                .amount(dto.getAmount())
                .build();
    }
}
