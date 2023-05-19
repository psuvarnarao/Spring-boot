package in.stackroute.ust.customer.utility;

import in.stackroute.ust.customer.domain.Customer;
import in.stackroute.ust.customer.dto.CustomerDto;

public class EntityDtoUtil {

    public static Customer toEntity(CustomerDto dto) {
        return new Customer(dto.id(), dto.name(), dto.email(), dto.password());
    }

    public static CustomerDto toDto(Customer entity) {
        return new CustomerDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword());
    }
}
