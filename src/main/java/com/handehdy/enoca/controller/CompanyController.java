package com.handehdy.enoca.controller;

import com.handehdy.enoca.dto.request.AddCompanyRequest;
import com.handehdy.enoca.dto.request.DeleteCompanyRequest;
import com.handehdy.enoca.dto.request.UpdateCompanyRequest;
import com.handehdy.enoca.repository.entity.Company;
import com.handehdy.enoca.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.handehdy.enoca.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(COMPANY)
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> addCompany (@RequestBody AddCompanyRequest dto) {
        return ResponseEntity.ok(companyService.addCompany(dto));
    }
    @PutMapping(UPDATE + "/{id}")
    public ResponseEntity<Boolean> updateCompany (@PathVariable Long id, @RequestBody UpdateCompanyRequest dto) {
        return ResponseEntity.ok(companyService.updateCompany(id,dto));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteCompany (@RequestBody DeleteCompanyRequest dto) {
        return ResponseEntity.ok(companyService.deleteCompany(dto));
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }
}
