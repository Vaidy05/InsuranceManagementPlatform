package com.example.InsuranceManagementPlatform.ResponseDto;

import java.util.Date;

public class PolicyResponseDto {

    private String policyNumber;

    private String policyType;

    private long coverage_amount;

    private int premium;

    private Date start_date;

    private Date end_date;

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

    public PolicyResponseDto(String policyNumber, String policyType, long coverage_amount, int premium, Date start_date, Date end_date) {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.coverage_amount = coverage_amount;
        this.premium = premium;
        this.start_date = start_date;
        this.end_date = end_date;
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

    public PolicyResponseDto() {
    }
}
