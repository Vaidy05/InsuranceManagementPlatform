package com.example.InsuranceManagementPlatform.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Entity
@Table
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String policyNumber;

    private String policyType;

    private long coverage_amount;

    private int premium;

    @Temporal(value = TemporalType.DATE)
    private Date start_date;

    @Temporal(value = TemporalType.DATE)
    private Date end_date;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
    private List<Claim> claimList;

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<Claim> claimList) {
        this.claimList = claimList;
    }


    public InsurancePolicy(String policyNumber, String policyType, long coverage_amount, int premium, String start_date, String end_date, Client client) throws ParseException {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.coverage_amount = coverage_amount;
        this.premium = premium;
        this.start_date = new SimpleDateFormat("dd/MM/yyyy").parse(start_date);
        this.end_date = new SimpleDateFormat("dd/MM/yyyy").parse(end_date);
        this.client = client;
    }

    public InsurancePolicy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public long getCoverage_amount() {
        return coverage_amount;
    }

    public void setCoverage_amount(long coverage_amount) {
        this.coverage_amount = coverage_amount;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
