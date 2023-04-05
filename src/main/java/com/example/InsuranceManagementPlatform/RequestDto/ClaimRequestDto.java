package com.example.InsuranceManagementPlatform.RequestDto;

public class ClaimRequestDto {

    private String claimNumber;

    private String description;

    private String claimDate;

    private String claimStatus;

    private String policyNumber;

    private int userId;

    public ClaimRequestDto() {
    }

    public ClaimRequestDto(String claimNumber, String description, String claimDate, String claimStatus, String policyNumber, int userId) {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.policyNumber = policyNumber;
        this.userId = userId;
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

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
