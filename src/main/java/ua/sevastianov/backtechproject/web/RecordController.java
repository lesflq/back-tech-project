package ua.sevastianov.backtechproject.web;
import ua.sevastianov.backtechproject.domain.Record;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.sevastianov.backtechproject.service.implementation.RecordServiceImpl;

import java.util.List;
@RestController
@RequestMapping("/record")
public class RecordController {
    private final RecordServiceImpl recordService;

    public RecordController(RecordServiceImpl recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    @ResponseBody
    public Record createRecord(@RequestBody Record record) {
        return recordService.createRecord(record);
    }

    @GetMapping("/{recordId}")
    @ResponseBody
    public ResponseEntity<Record> getRecord(@PathVariable(name = "recordId") Long recordId) {
        return recordService.getRecord(recordId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Record>> getRecords(
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

        return ResponseEntity.ok(recordService.getRecordsByCategory(userId, categoryId));
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable(name = "recordId") Long recordId) {
        if (recordService.deleteRecord(recordId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
