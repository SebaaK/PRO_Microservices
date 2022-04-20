package kots.customer.controller;

import kots.customer.domain.dto.CustomerDto;
import kots.customer.mapper.CustomerMapper;
import kots.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
class CustomerController {

    private final CustomerService service;

    @GetMapping("/{idCustomer}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable long idCustomer) {
        return ResponseEntity.ok(CustomerMapper.mapToCustomerDto(service.getCustomerById(idCustomer)));
    }

}
