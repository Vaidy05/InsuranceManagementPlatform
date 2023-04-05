package com.example.InsuranceManagementPlatform.Repository;

import com.example.InsuranceManagementPlatform.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
