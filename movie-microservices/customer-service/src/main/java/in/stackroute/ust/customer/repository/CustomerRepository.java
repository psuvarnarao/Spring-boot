package in.stackroute.ust.customer.repository;

import in.stackroute.ust.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
