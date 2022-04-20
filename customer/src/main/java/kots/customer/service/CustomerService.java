package kots.customer.service;

import kots.customer.domain.Customer;
import kots.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;


    public Customer getCustomerById(long idCustomer) {
        return repository.findCustomerById(idCustomer);
    }
}
