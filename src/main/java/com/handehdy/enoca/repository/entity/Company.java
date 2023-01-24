package com.handehdy.enoca.repository.entity;

import com.handehdy.enoca.repository.enums.CompanyType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.lang.reflect.Type;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@Table(name = "companies")
@Entity
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CompanyType type;
    private String country;
    private String address;
    private String phone;

}
