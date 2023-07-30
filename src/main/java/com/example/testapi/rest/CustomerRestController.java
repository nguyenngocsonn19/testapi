package com.example.testapi.rest;

import com.example.testapi.dao.CustomerRepository;
import com.example.testapi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private final CustomerRepository repository;

    @Autowired
    public CustomerRestController(CustomerRepository theCustomerRepository){repository = theCustomerRepository;}

    @GetMapping("/emp")
    List<Customer> all(){
        return repository.findAll();
    }

    @PostMapping("/emp")
    Customer newEmployee(@RequestBody Customer newEmployee){return repository.save(newEmployee);}

    @GetMapping("/emp/{id}")
    Customer one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException(id));
    }

    @DeleteMapping("/emp/{id}")
    void deleteEmployee(@PathVariable Integer id){
        repository.deleteById(id);
    }


    @PutMapping("/emp/{id}")
    Customer updateCustomer(@RequestBody Customer updateCustomer,@PathVariable Integer id){
        return  repository.findById(id)
                .map(customer -> {
                    customer.setId(updateCustomer.getId());
                    customer.setFirstName(updateCustomer.getFirstName());
                    customer.setLastName(customer.getLastName());


                    return repository.save(customer);

                })
                .orElseThrow(()-> new CustomerNotFoundException(id));
    }


}