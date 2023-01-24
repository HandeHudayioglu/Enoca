package com.handehdy.enoca.service;

import com.handehdy.enoca.dto.request.AddEmployeeRequest;
import com.handehdy.enoca.dto.request.DeleteEmployeeRequest;
import com.handehdy.enoca.dto.request.UpdateEmployeeRequest;
import com.handehdy.enoca.dto.response.GetAllEmployeesResponse;
import com.handehdy.enoca.exception.ErrorType;
import com.handehdy.enoca.exception.ManagerException;
import com.handehdy.enoca.repository.IEmployeeRepository;
import com.handehdy.enoca.repository.entity.Company;
import com.handehdy.enoca.repository.entity.Employee;
import com.handehdy.enoca.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class EmployeeService extends ServiceManager<Employee,Long>  {

    private final IEmployeeRepository employeeRepository;
    private final CompanyService companyService;

    public EmployeeService(IEmployeeRepository employeeRepository, CompanyService companyService) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
    }
   /*
    public boolean addEmployee(AddEmployeeRequest dto){
        try {
            Employee employee = employeeRepository.save(Employee.builder()
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .address(dto.getAddress())
                    .age(dto.getAge())
                    .email(dto.getEmail())
                    .department(dto.getDepartment())
                    .company(companyService.findById(dto.getCompanyId()))
                    .build());
            return true;
        } catch(Exception e) {
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_CREATED);
        }
    } */

    public Boolean addEmployee( AddEmployeeRequest dto){
        try {
            Employee employee = new Employee();
            employee.setDepartment(dto.getDepartment());
            employee.setAge(dto.getAge());
            employee.setAddress(dto.getAddress());
            employee.setCompany(companyService.findById(dto.getCompanyId()));
            employee.setFirstName(dto.getFirstName());
            employee.setLastName(dto.getLastName());
            employee.setEmail(dto.getEmail());
             employeeRepository.save(employee);
             return true;

        } catch(Exception e){
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_CREATED);
        }
    }
   /*
    public boolean updateEmployee(UpdateEmployeeRequest dto) {
        try {
            Optional<Employee> employee = employeeRepository.findById(dto.getId());
            if (employee.isPresent()) {
                employee.get().setFirstName(dto.getFirstName());
                employee.get().setLastName(dto.getLastName());
                employee.get().setAge(dto.getAge());
                employee.get().setAddress(dto.getAddress());
                employee.get().setCompany(companyService.findById(dto.getCompanyId()));
                employee.get().setEmail(dto.getEmail());
                employee.get().setDepartment(dto.getDepartment());
                save(employee.get());
                return true;
            } else {
                throw new ManagerException(ErrorType.EMPYOLEE_NOT_FOUND);
            }
        }
            catch (Exception e) {
                throw new ManagerException(ErrorType.EMPYOLEE_NOT_UPDATED);
            }
        } */

    public Boolean updateEmployee(Long id, UpdateEmployeeRequest dto) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            if (employee.isPresent()) {
                Employee updateEmployee = employee.get();
                updateEmployee.setFirstName(dto.getFirstName());
                updateEmployee.setLastName(dto.getLastName());
                updateEmployee.setAge(dto.getAge());
                updateEmployee.setAddress(dto.getAddress());
                updateEmployee.setDepartment(dto.getDepartment());
                updateEmployee.setEmail(dto.getEmail());
                updateEmployee.setCompany(companyService.findById(dto.getCompanyId()));
                employeeRepository.save(updateEmployee);
                return true;
            } else {
                throw new ManagerException(ErrorType.EMPYOLEE_NOT_FOUND);
            }
        }catch(Exception e){
                throw new ManagerException(ErrorType.EMPYOLEE_NOT_UPDATED);
            }
        }

        /*
        public boolean deleteEmployee(DeleteEmployeeRequest dto){
        Optional<Employee> employee = employeeRepository.findById(dto.getId());
        if(employee.isPresent()){
            deleteById(employee.get().getId());
            return true;
        } else {
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_FOUND);
        }
        }*/

    public Boolean deleteEmployee(DeleteEmployeeRequest dto) {
        Optional<Employee> employee = employeeRepository.findById(dto.getId());
        if(employee.isPresent()){
            employeeRepository.deleteById(employee.get().getId());
            return true;
        } else {
            throw new ManagerException(ErrorType.EMPYOLEE_NOT_FOUND);
        }
    }
        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }
    }

