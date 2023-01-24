package com.handehdy.enoca.repository;

import com.handehdy.enoca.repository.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
}
