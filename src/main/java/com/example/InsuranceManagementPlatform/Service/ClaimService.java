package com.example.InsuranceManagementPlatform.Service;

import com.example.InsuranceManagementPlatform.Model.Claim;
import com.example.InsuranceManagementPlatform.Model.ClaimStatus;
import com.example.InsuranceManagementPlatform.Model.Client;
import com.example.InsuranceManagementPlatform.Model.InsurancePolicy;
import com.example.InsuranceManagementPlatform.Repository.ClaimRepository;
import com.example.InsuranceManagementPlatform.Repository.ClientRepository;
import com.example.InsuranceManagementPlatform.Repository.PolicyRepository;
import com.example.InsuranceManagementPlatform.RequestDto.ClaimRequestDto;
import com.example.InsuranceManagementPlatform.ResponseDto.ClaimResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    ClientRepository clientRepository;

    public List<ClaimResponseDto> getAllClaims(){
        try{
            List<Claim> claimList =  claimRepository.findAll();
            List<ClaimResponseDto> claimResponseDtoList = new ArrayList<>();
            for(Claim claim : claimList){
                ClaimResponseDto claimResponseDto = new ClaimResponseDto(claim.getClaimNumber(),claim.getDescription(),claim.getClaimDate(),claim.getClaimStatus());
                claimResponseDtoList.add(claimResponseDto);
            }

            return claimResponseDtoList;
        }
        catch (Exception e){
            return null;
        }
    }
    public ClaimResponseDto getClaimById(int id){
        try{
            Claim claim = claimRepository.findById(id).get();
            ClaimResponseDto claimResponseDto = new ClaimResponseDto(claim.getClaimNumber(),claim.getDescription(),claim.getClaimDate(),claim.getClaimStatus());

            return claimResponseDto;
        }
        catch (Exception e){
            return null;
        }
    }

    public String addClaim(ClaimRequestDto claimRequestDto){
        try{
            InsurancePolicy policy = policyRepository.findByPolicyNumber(claimRequestDto.getPolicyNumber());
            Client client = clientRepository.findById(claimRequestDto.getUserId()).get();
            ClaimStatus claimStatus = ClaimStatus.APPLIED;

            if(claimRequestDto.getClaimStatus().toLowerCase().equals("completed"))
                claimStatus = ClaimStatus.COMPLETED;
            else if(claimRequestDto.getClaimStatus().toLowerCase().equals("canceled"))
                claimStatus = ClaimStatus.CANCELED;

            Claim claim = new Claim(claimRequestDto.getClaimNumber(),claimRequestDto.getDescription(),claimRequestDto.getClaimDate(),claimStatus,policy,client);
            clientRepository.save(client);
            claimRepository.save(claim);

            return "Claim successfully added";
        }
        catch(Exception e){
            return e.toString();
        }
    }

    public String updateClaim(int id, ClaimRequestDto claimRequestDto){
        try{
            Claim claim = claimRepository.findById(id).get();
            InsurancePolicy policy = policyRepository.findByPolicyNumber(claimRequestDto.getPolicyNumber());
            Client client = clientRepository.findById(claimRequestDto.getUserId()).get();
            ClaimStatus claimStatus = ClaimStatus.APPLIED;

            if(claimRequestDto.getClaimStatus().toLowerCase().equals("completed"))
                claimStatus = ClaimStatus.COMPLETED;
            else if(claimRequestDto.getClaimStatus().toLowerCase().equals("canceled"))
                claimStatus = ClaimStatus.CANCELED;

            claim.setClaimNumber(claimRequestDto.getClaimNumber());
            claim.setClaimDate(new SimpleDateFormat("dd/MM/yyyy").parse(claimRequestDto.getClaimDate()));
            claim.setDescription(claimRequestDto.getDescription());
            claim.setClaimStatus(claimStatus);
            claim.setPolicy(policy);
            claim.setClient(client);

            clientRepository.save(client);
            claimRepository.save(claim);

            return "Claim updated successfully";
        }
        catch(Exception e){
            return e.toString();
        }
    }

    public String deleteClaim(int id){
        try{
            Claim claim = claimRepository.findById(id).get();

            InsurancePolicy policy = claim.getPolicy();
            List<Claim> claimList = policy.getClaimList();
            claimList.remove(claim);
            policy.setClaimList(claimList);

            Client client = claim.getClient();
            List<Claim> userClaimList = client.getClaimList();
            userClaimList.remove(claim);
            client.setClaimList(userClaimList);

            claimRepository.delete(claim);
            clientRepository.save(client);
            policyRepository.save(policy);

            return "Claim successfully deleted";
        }
        catch(Exception e){
            return e.toString();
        }
    }
}
