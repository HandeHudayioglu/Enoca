package com.handehdy.enoca.service;

import com.handehdy.enoca.dto.request.*;
import com.handehdy.enoca.dto.response.GetAllCompaniesResponse;
import com.handehdy.enoca.exception.ErrorType;
import com.handehdy.enoca.exception.ManagerException;
import com.handehdy.enoca.dto.response.AddCompanyResponse;
import com.handehdy.enoca.mapper.ICompanyMapper;
import com.handehdy.enoca.repository.ICompanyRepository;
import com.handehdy.enoca.repository.entity.Company;
import com.handehdy.enoca.repository.entity.Employee;
import com.handehdy.enoca.utility.ServiceManager;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService extends ServiceManager<Company,Long> {

    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }
    /*
    public AddCompanyResponse addCompany(AddCompanyRequest dto) {
        try {
            Company company = companyRepository.save(ICompanyMapper.INSTANCE.toCompany(dto));
            return ICompanyMapper.INSTANCE.toAddCompanyResponse(company);

        } catch (Exception e) {
            throw new ManagerException(ErrorType.COMPANY_NOT_CREATED);
        }
    }*/

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

        /*
    public boolean updateCompany(UpdateCompanyRequest dto) {
        try {
            Optional<Company> company = companyRepository.findById(dto.getId());
            if(company.isPresent()){
                company.get().setName(dto.getName());
                company.get().setCountry(dto.getCountry());
                company.get().setAddress(dto.getAddress());
                company.get().setType(dto.getType());
                company.get().setPhone(dto.getPhone());
                save(company.get());
                return true;
            } else {
                throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
            }
        } catch(Exception e){
            throw new ManagerException(ErrorType.COMPANY_NOT_UPDATED);
        }
    } */

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
  /*
    public boolean deleteCompany(DeleteCompanyRequest dto) {
        Optional<Company> company = companyRepository.findById(dto.getId());
        if(company.isPresent()) {
            deleteById(company.get().getId());
            return true;
        } else {
            throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
    } */

    public Boolean deleteCompany(DeleteCompanyRequest dto) {
        Optional<Company> company = companyRepository.findById(dto.getId());
        if(company.isPresent()){
            companyRepository.deleteById(company.get().getId());
            return true;
        } else {
            throw new ManagerException(ErrorType.COMPANY_NOT_FOUND);
        }
    }
  /*
    public List<GetAllCompaniesResponse> getAllCompanies(){
        List<Company> companies = findAll();
        return companies.stream().map(c -> ICompanyMapper.INSTANCE.toGetAllCompaniesResponse(c)).collect(Collectors.toList());
    } */

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
}
