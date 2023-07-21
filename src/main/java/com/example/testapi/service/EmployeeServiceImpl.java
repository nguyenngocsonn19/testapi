package com.example.testapi.service;

import com.example.testapi.dao.EmployeeRepository;
import com.example.testapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl  implements EmployeeService{


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){employeeRepository = theEmployeeRepository;}
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllOrderByLastNameAsc();
    }



    @Override
    public Employee findById(int theId) {
        Optional<Employee> results = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (results.isPresent()){
            theEmployee = results.get();
        }
        else{
            throw  new RuntimeException("we did not find employee id" + theId);

        }
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public List<Employee> searchBy(String theName) {
        List<Employee> results = null;
        if (theName != null &&(theName.trim().length()>0)){
            results = employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);

        }
        else {
            results = findAll();
        }
        return results;

    }
}