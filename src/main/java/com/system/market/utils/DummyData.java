package com.system.market.utils;

import com.system.market.entities.Employee;
import com.system.market.repository.MarketRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    MarketRepository marketRepository;

//  @PostConstruct
    public void savePosts(){

        List<Employee> employeeList = new ArrayList<>();
        Employee employeelist1 = new Employee();
        employeelist1.setName("Bruno Alexandre");
        employeelist1.setCpf(999999L);
        employeelist1.setEmail("teste@teste.com");
        employeelist1.setPhone(99999L);
        employeelist1.setShift("Noite");

        employeeList.add(employeelist1);

        for(Employee employee: employeeList){
            Employee employeeSave = marketRepository.save(employee);
            System.out.println(employee.getId());
        }


    }
}

