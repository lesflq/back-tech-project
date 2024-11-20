package ua.sevastianov.backtechproject.web;
import ua.sevastianov.backtechproject.DTO.orderRecord.OrderRecordDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.sevastianov.backtechproject.service.implementation.OrderRecordServiceImpl;

import java.util.List;
@RestController
@RequestMapping("/record")
public class OrderRecordController {
    private final OrderRecordServiceImpl recordService;

    public OrderRecordController(OrderRecordServiceImpl recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public OrderRecordDTO createRecord(@RequestBody OrderRecordDTO record) {
        return recordService.createRecord(record);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<OrderRecordDTO> getRecord(@PathVariable(name = "recordId") Long recordId) {
        return recordService.getRecord(recordId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderRecordDTO>> getRecords(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long categoryId) {

        if ((userId == null && categoryId == null) || (userId == 0 && categoryId == 0)) {
            System.out.println("No one params found");
            return ResponseEntity.badRequest().build();
        }

        if (categoryId == null || categoryId == 0) {
            return ResponseEntity.ok(recordService.getRecordsByUser(userId));
        }
        if (userId == null || userId == 0) {
            return ResponseEntity.ok(recordService.getRecordsByCategory(categoryId));
        }

        return ResponseEntity.ok(recordService.getRecordsByBothParams(userId, categoryId));
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable(name = "recordId") Long recordId) {
        if (recordService.deleteRecord(recordId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
