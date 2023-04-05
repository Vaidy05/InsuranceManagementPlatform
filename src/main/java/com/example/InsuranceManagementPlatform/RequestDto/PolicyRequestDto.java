package com.example.InsuranceManagementPlatform.RequestDto;

import java.util.Date;

public class PolicyRequestDto {

    private String policyNumber;

    private String policyType;

    private long coverage_amount;

    private int premium;

    private int userId;

    private String start_date;

    private String end_date;

    public PolicyRequestDto(String policyNumber, String policyType, long coverage_amount, int premium, String start_date, String end_date, int userId) {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.coverage_amount = coverage_amount;
        this.premium = premium;
        this.start_date = start_date;
        this.end_date = end_date;
        this.userId = userId;
    }

    public PolicyRequestDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }


}
