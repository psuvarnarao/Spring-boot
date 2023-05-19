package in.stackroute.ust.customer.service;

import in.stackroute.ust.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> findById(int id);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByEmailAndPassword(String email, String password);

    List<Customer> findAll();

    Customer updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
