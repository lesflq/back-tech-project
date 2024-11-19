package ua.sevastianov.backtechproject.web;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import ua.sevastianov.backtechproject.service.implementation.CustomerServiceImpl;
import ua.sevastianov.backtechproject.domain.Customer;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(name = "customerId") Long customerId) {
        return customerService.getCustomer(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "customerId") Long customerId) {
        if (customerService.deleteCustomer(customerId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
