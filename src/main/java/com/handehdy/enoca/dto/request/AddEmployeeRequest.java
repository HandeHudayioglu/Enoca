package com.handehdy.enoca.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddEmployeeRequest {

    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String department;
    @Email(message = "Invalid email")
    @NotBlank
    private String email;
    private Long companyId;
}
