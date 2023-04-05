package com.example.InsuranceManagementPlatform.Repository;

import com.example.InsuranceManagementPlatform.Model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Integer> {
}
