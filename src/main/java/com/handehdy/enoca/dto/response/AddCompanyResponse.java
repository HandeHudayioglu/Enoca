package com.handehdy.enoca.dto.response;

import com.handehdy.enoca.repository.enums.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCompanyResponse {
    private Long id;
    private String name;
    private CompanyType type;
    private String country;
    private String address;
    private String phone;
}
