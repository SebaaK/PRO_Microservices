package kots.customer.mapper;

import kots.customer.domain.Customer;
import kots.customer.domain.dto.CustomerDto;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(final Customer customer) {
        return new CustomerDto(customer.getId(), customer.getFirstName(), customer.getLastName());
    }

    public static Customer mapToCustomer(final CustomerDto customerDto) {
        return new Customer(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName());
    }

}
