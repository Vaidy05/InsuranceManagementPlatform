package com.example.InsuranceManagementPlatform.Repository;

import com.example.InsuranceManagementPlatform.Model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<InsurancePolicy,Integer> {
    InsurancePolicy findByPolicyNumber(String policyNumber);
}
