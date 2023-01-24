package com.handehdy.enoca.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllEmployeesResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private int age;
    private String email;
    private String address;
    private Long companyId;
    private String companyName;
}
