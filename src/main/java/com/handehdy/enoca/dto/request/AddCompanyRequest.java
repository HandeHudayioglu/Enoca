package com.handehdy.enoca.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCompanyRequest {

    private String name;
    private String type;
    private String country;
    private String address;
    private String phone;
}
