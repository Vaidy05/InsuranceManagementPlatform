package com.example.InsuranceManagementPlatform.Controller;

import com.example.InsuranceManagementPlatform.Model.InsurancePolicy;
import com.example.InsuranceManagementPlatform.RequestDto.PolicyRequestDto;
import com.example.InsuranceManagementPlatform.ResponseDto.PolicyResponseDto;
import com.example.InsuranceManagementPlatform.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @GetMapping("/get_all_policies")
    public List<PolicyResponseDto> getAllPolicies(){
        try{
            return policyService.getAllPolicies();
        }
        catch(Exception e){
            return null;
        }
    }

    @GetMapping("/get_policy_by_id/{id}")
    public PolicyResponseDto getPolicyById(@PathVariable int id){
        try{
            return policyService.getPolicyById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping("/add_policy")
    public String addPolicy(@RequestBody PolicyRequestDto policyRequestDto){
        try{
            return policyService.addPolicy(policyRequestDto);
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PutMapping("/update_policy/{id}")
    public String updatePolicy(@PathVariable int id, @RequestBody PolicyRequestDto policyRequestDto){
        try{
            return policyService.updatePolicy(id,policyRequestDto);
        }
        catch(Exception e){
            return null;
        }
    }

    @DeleteMapping("/delete_policy/{id}")
    public String deletePolicy(@PathVariable int id){
        try{
            return policyService.deletePolicy(id);
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
