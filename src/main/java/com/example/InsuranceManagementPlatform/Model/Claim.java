package com.example.InsuranceManagementPlatform.Model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String claimNumber;

    private String description;

    @Temporal(value = TemporalType.DATE)
    private Date claimDate;

    @Enumerated(value = EnumType.STRING)
    private ClaimStatus claimStatus;

    @ManyToOne
    @JoinColumn
    private InsurancePolicy policy;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn
    private Client client;

    public Claim(String claimNumber, String description, String claimDate, ClaimStatus claimStatus,InsurancePolicy policy,Client client) throws ParseException {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = new SimpleDateFormat("dd/MM/yyyy").parse(claimDate);
        this.claimStatus = claimStatus;
        this.policy = policy;
        this.client = client;
    }

    public Claim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    public InsurancePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(InsurancePolicy policy) {
        this.policy = policy;
    }
}
