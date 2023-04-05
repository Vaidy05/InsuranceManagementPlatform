package com.example.InsuranceManagementPlatform.ResponseDto;

import com.example.InsuranceManagementPlatform.Model.ClaimStatus;

import java.util.Date;

public class ClaimResponseDto {

    private String claimNumber;

    private String description;

    private Date claimDate;

    private String claimStatus;

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

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public ClaimResponseDto() {
    }

    public ClaimResponseDto(String claimNumber, String description, Date claimDate, ClaimStatus claimStatus) {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus.toString();
    }
}
