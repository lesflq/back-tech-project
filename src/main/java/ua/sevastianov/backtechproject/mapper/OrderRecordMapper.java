package ua.sevastianov.backtechproject.mapper;

import org.mapstruct.Mapper;
import ua.sevastianov.backtechproject.DTO.orderRecord.OrderRecordDTO;
import ua.sevastianov.backtechproject.domain.orderRecord.OrderRecord;

public interface OrderRecordMapper {

    OrderRecordDTO toEntryDTO(OrderRecord record);

    OrderRecord toEntity(OrderRecordDTO orderRecordDTO);


}
