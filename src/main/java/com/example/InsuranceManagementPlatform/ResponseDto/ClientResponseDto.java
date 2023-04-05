package com.example.InsuranceManagementPlatform.ResponseDto;

public class ClientResponseDto {
    private String name;

    private String dob;

    private String address;

    private String contact_info;

    public ClientResponseDto(String name, String dob, String address, String contact_info) {
            this.name = name;
            this.dob = dob;
            this.address = address;
            this.contact_info = contact_info;
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
    public ClientResponseDto() {
        }
}


