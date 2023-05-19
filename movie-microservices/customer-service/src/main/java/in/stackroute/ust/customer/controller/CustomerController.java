package in.stackroute.ust.customer.controller;

import in.stackroute.ust.customer.dto.LoginDto;
import in.stackroute.ust.customer.domain.Customer;
import in.stackroute.ust.customer.dto.CustomerDto;
import in.stackroute.ust.customer.service.CustomerService;
import static in.stackroute.ust.customer.utility.EntityDtoUtil.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto dto) {
        var customerEntity = toEntity(dto);
        logger.info("Customer Entity: {}", customerEntity);
        Customer customer = customerService.createCustomer(customerEntity);
        logger.info("Customer: {}", customer);
        return ResponseEntity.ok(toDto(customer));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDto> loginCustomer(@Valid @RequestBody LoginDto dto) {
        var optional = customerService.findByEmailAndPassword(dto.email(), dto.password());
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id) {
        var optional = customerService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }

    @GetMapping
    public ResponseEntity<CustomerDto> getCustomerByEmail(@RequestParam String email) {
        var optional = customerService.findByEmail(email);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }
}
