package com.handehdy.enoca.service;

import com.handehdy.enoca.dto.request.*;
import com.handehdy.enoca.exception.ErrorType;
import com.handehdy.enoca.exception.ManagerException;
import com.handehdy.enoca.repository.ICompanyRepository;
import com.handehdy.enoca.repository.entity.Company;
import com.handehdy.enoca.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CompanyService extends ServiceManager<Company,Long> {

    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }

    public Boolean addCompany(AddCompanyRequest dto) {
        try {
            Company company = new Company();
            company.setName(dto.getName());
            company.setType(dto.getType());
            company.setCountry(dto.getCountry());
            company.setAddress(dto.getAddress());
            company.setPhone(dto.getPhone());
            companyRepository.save(company);
            return true;

        } catch(Exception e){
            throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
        }



    public Boolean updateCompany(Long id,UpdateCompanyRequest dto) {
        try {
            Optional<Company> company = companyRepository.findById(dto.getId());
            if (company.isPresent()) {
                Company updateCompany = company.get();
                updateCompany.setName(dto.getName());
                updateCompany.setType(dto.getType());
                updateCompany.setCountry(dto.getCountry());
                updateCompany.setAddress(dto.getAddress());
                updateCompany.setPhone(dto.getPhone());
                companyRepository.save(updateCompany);
                return true;
            } else {
                throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
            }
        }catch(Exception e){
            throw new ManagerException(ErrorType.COMPANY_NOT_UPDATED);
        }
    }


    public Boolean deleteCompany(DeleteCompanyRequest dto) {
        Optional<Company> company = companyRepository.findById(dto.getId());
        if(company.isPresent()){
            companyRepository.deleteById(company.get().getId());
            return true;
        } else {
            throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
    }


    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
}
