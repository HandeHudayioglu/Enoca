package com.handehdy.enoca.controller;

import com.handehdy.enoca.dto.request.AddEmployeeRequest;
import com.handehdy.enoca.dto.request.DeleteEmployeeRequest;
import com.handehdy.enoca.dto.request.UpdateEmployeeRequest;
import com.handehdy.enoca.dto.response.GetAllEmployeesResponse;
import com.handehdy.enoca.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.handehdy.enoca.constant.EndPoint.EMPLOYEE;
import static com.handehdy.enoca.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> addEmployee(@RequestBody @Valid AddEmployeeRequest dto) {
        return ResponseEntity.ok(employeeService.addEmployee(dto));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> updateEmployee (@RequestBody @Valid UpdateEmployeeRequest dto){
        return ResponseEntity.ok(employeeService.updateEmployee(dto));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteEmployee(@RequestBody DeleteEmployeeRequest dto) {
        return ResponseEntity.ok(employeeService.deleteEmployee(dto));
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<GetAllEmployeesResponse>> findAll(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

}
