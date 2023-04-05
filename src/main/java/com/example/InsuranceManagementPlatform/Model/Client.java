package com.example.InsuranceManagementPlatform.Model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String dob;

    private String address;

    private String contact_info;

    @OneToMany(mappedBy="client",cascade = CascadeType.ALL)
    private List<InsurancePolicy> policyList;

    @OneToMany(mappedBy="client",cascade = CascadeType.ALL)
    private List<Claim> claimList;

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<Claim> claimList) {
        this.claimList = claimList;
    }

    public Client() {
    }
    public Client(String name, String dob, String address, String contact_info) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.contact_info = contact_info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public List<InsurancePolicy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<InsurancePolicy> policyList) {
        this.policyList = policyList;
    }
}
