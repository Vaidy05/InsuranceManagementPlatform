package com.example.InsuranceManagementPlatform.Service;

import com.example.InsuranceManagementPlatform.Model.Claim;
import com.example.InsuranceManagementPlatform.Model.Client;
import com.example.InsuranceManagementPlatform.Model.InsurancePolicy;
import com.example.InsuranceManagementPlatform.Repository.ClaimRepository;
import com.example.InsuranceManagementPlatform.Repository.ClientRepository;
import com.example.InsuranceManagementPlatform.Repository.PolicyRepository;
import com.example.InsuranceManagementPlatform.RequestDto.PolicyRequestDto;
import com.example.InsuranceManagementPlatform.ResponseDto.PolicyResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PolicyService {

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClaimRepository claimRepository;

    public List<PolicyResponseDto> getAllPolicies(){
        try{
            List<InsurancePolicy> policyList =  policyRepository.findAll();
            List<PolicyResponseDto> policyResponseDtoList = new ArrayList<>();

            for(InsurancePolicy policy : policyList){
                PolicyResponseDto policyResponseDto = new PolicyResponseDto(policy.getPolicyNumber(),policy.getPolicyType(),policy.getCoverage_amount(),policy.getPremium(),policy.getStart_date(),policy.getEnd_date());
                policyResponseDtoList.add(policyResponseDto);
            }

            return policyResponseDtoList;
        }
        catch (Exception e){
            return null;
        }
    }

    public PolicyResponseDto getPolicyById(int id){
        try{
            InsurancePolicy policy = policyRepository.findById(id).get();

            PolicyResponseDto policyResponseDto = new PolicyResponseDto(policy.getPolicyNumber(),policy.getPolicyType(),policy.getCoverage_amount(),policy.getPremium(),policy.getStart_date(),policy.getEnd_date());

            return policyResponseDto;
        }
        catch(Exception e){
            return null;
        }
    }

    public String addPolicy(PolicyRequestDto policyRequestDto){
        try{
            Client client = clientRepository.findById(policyRequestDto.getUserId()).get();

            InsurancePolicy policy = new InsurancePolicy(policyRequestDto.getPolicyNumber(),
                                                         policyRequestDto.getPolicyType(),
                                                         policyRequestDto.getCoverage_amount(),
                                                         policyRequestDto.getPremium(),
                                                         policyRequestDto.getStart_date(),
                                                         policyRequestDto.getEnd_date(),client);
            policyRepository.save(policy);
            return "Policy successfully added";
        }
        catch(Exception e){
            return e.toString();
        }
    }

    public String updatePolicy(int id, PolicyRequestDto policyRequestDto){
        try{
            InsurancePolicy policy = policyRepository.findById(id).get();
            Client client = clientRepository.findById(policyRequestDto.getUserId()).get();

            policy.setPolicyNumber(policyRequestDto.getPolicyNumber());
            policy.setPolicyType(policyRequestDto.getPolicyType());
            policy.setCoverage_amount(policyRequestDto.getCoverage_amount());
            policy.setPremium(policyRequestDto.getPremium());
            policy.setStart_date(new SimpleDateFormat("dd/MM/yyyy").parse(policyRequestDto.getStart_date()));
            policy.setEnd_date(new SimpleDateFormat("dd/MM/yyyy").parse(policyRequestDto.getEnd_date()));
            policy.setClient(client);

            policyRepository.save(policy);
            return "Policy successfully updated";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    public String deletePolicy(int id){
        try{
            InsurancePolicy policy = policyRepository.findById(id).get();

            Client client = policy.getClient();
            List<InsurancePolicy> policyList = client.getPolicyList();
            policyList.remove(policy);
            client.setPolicyList(policyList);

            List<Claim> claimList = policy.getClaimList();

            if(claimList!=null)
                claimRepository.deleteAll(claimList);

            clientRepository.save(client);
            policyRepository.deleteById(id);


            return "Policy successfully deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
