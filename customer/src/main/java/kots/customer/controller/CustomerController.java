package kots.customer.controller;

import kots.customer.controller.response.GetCustomerProductsResponse;
import kots.customer.domain.Customer;
import kots.customer.domain.dto.CustomerDto;
import kots.customer.mapper.CustomerMapper;
import kots.customer.service.CustomerService;
import kots.customer.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer", produces = { MediaType.APPLICATION_JSON_VALUE })
class CustomerController {

    private final CustomerService customerService;
    private final ProductService productService;

    @GetMapping("/{idCustomer}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable long idCustomer) {
        return ResponseEntity.ok(CustomerMapper.mapToCustomerDto(customerService.getCustomerById(idCustomer)));
    }

    @GetMapping("/{idCustomer}/products")
    ResponseEntity<GetCustomerProductsResponse> getCustomerProducts(@PathVariable long idCustomer) {
        Customer customer = customerService.getCustomerById(idCustomer);

        return ResponseEntity.ok(
                GetCustomerProductsResponse.builder()
                        .customerId(customer.getId())
                        .fullName(customer.getFirstName() + " " + customer.getLastName())
                        .accounts(productService.findCustomerAccounts(idCustomer))
                        .cards(productService.findCardsOfCustomer(idCustomer))
                        .build()
        );
    }
}
