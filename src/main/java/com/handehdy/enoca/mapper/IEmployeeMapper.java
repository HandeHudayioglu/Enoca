package com.handehdy.enoca.mapper;

import com.handehdy.enoca.dto.request.AddEmployeeRequest;
import com.handehdy.enoca.dto.response.GetAllEmployeesResponse;
import com.handehdy.enoca.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IEmployeeMapper {

    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);
    Employee toEmployee(final AddEmployeeRequest dto);
    GetAllEmployeesResponse toGetAllEmployeesResponse(final Employee employee);
}
