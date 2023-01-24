package com.handehdy.enoca.utility;

import com.handehdy.enoca.repository.entity.Company;
import com.handehdy.enoca.repository.entity.Employee;
import com.handehdy.enoca.repository.enums.CompanyType;
import com.handehdy.enoca.service.CompanyService;
import com.handehdy.enoca.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Datas {

    private  final EmployeeService employeeService;
    private final CompanyService companyService;

    @PostConstruct
    private  void create(){
        saveImplToDatabase();
    }

    private void saveImplToDatabase() {

        Company c1 = Company.builder()
                .name("Enoca")
                .address("Istanbul")
                .phone("0555765342")
                .type(CompanyType.TECHNOLOGY)
                .country("Turkey").build();
        companyService.save(c1);

        Company c2 = Company.builder()
                .name("Amazon")
                .address("Washington")
                .phone("4539474902")
                .type(CompanyType.TECHNOLOGY)
                .country("USA").build();
        companyService.save(c2);

        Employee e1 = Employee.builder()
                .firstName("Can")
                .lastName("Demir")
                .company(c1)
                .age(25)
                .department("Software")
                .email("can@gmail.com")
                .address("İstanbul")
                .build();
        employeeService.save(e1);

        Employee e2 = Employee.builder()
                .firstName("John")
                .lastName("Smith")
                .company(c2)
                .age(30)
                .department("Software")
                .email("john@gmail.com")
                .address("New York")
                .build();
        employeeService.save(e2);
    }
}
