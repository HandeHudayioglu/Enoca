package com.handehdy.enoca.mapper;

import com.handehdy.enoca.dto.request.AddCompanyRequest;
import com.handehdy.enoca.dto.response.AddCompanyResponse;
import com.handehdy.enoca.dto.response.GetAllCompaniesResponse;
import com.handehdy.enoca.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICompanyMapper {

    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    Company toCompany (final AddCompanyRequest dto);
    AddCompanyResponse toAddCompanyResponse(final Company company);
    GetAllCompaniesResponse toGetAllCompaniesResponse(final Company company);
}
