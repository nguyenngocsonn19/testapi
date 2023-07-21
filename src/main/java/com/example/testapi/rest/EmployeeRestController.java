package com.example.testapi.rest;

import com.example.testapi.dao.EmployeeRepository;
import com.example.testapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeRepository  repository;

    @Autowired
    public EmployeeRestController(EmployeeRepository theEmployeeRepository){repository = theEmployeeRepository;}

    @GetMapping("/emp")
    List<Employee> all(){
        return repository.findAll();
    }

    @PostMapping("/emp")
    Employee newEmployee(@RequestBody Employee newEmployee){return repository.save(newEmployee);}

    @GetMapping("/emp/{id}")
    Employee one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/emp/{id}")
    void deleteEmployee(@PathVariable Integer id){
        repository.deleteById(id);
    }
}