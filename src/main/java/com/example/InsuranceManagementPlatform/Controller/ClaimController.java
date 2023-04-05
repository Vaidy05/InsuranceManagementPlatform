package com.example.InsuranceManagementPlatform.Controller;

import com.example.InsuranceManagementPlatform.Model.Claim;
import com.example.InsuranceManagementPlatform.RequestDto.ClaimRequestDto;
import com.example.InsuranceManagementPlatform.ResponseDto.ClaimResponseDto;
import com.example.InsuranceManagementPlatform.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/claim")
public class ClaimController {
    @Autowired
    ClaimService claimService;

    @GetMapping("/get_all_claims")
    public List<ClaimResponseDto> getAllClaims(){
        try{
            return claimService.getAllClaims();

        }
        catch (Exception e){
            return null;
        }
    }

    @GetMapping("/get_claim_by_id/{id}")
    public ClaimResponseDto getClaimById(@PathVariable int id){
        try{
            return claimService.getClaimById(id);
        }
        catch (Exception e){
            return null;
        }
    }

    @PostMapping("/add_claim")
    public String addClaim(@RequestBody ClaimRequestDto claimRequestDto){
        try{
            return claimService.addClaim(claimRequestDto);
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PutMapping("/update_claim/{id}")
    public String updateClaim(@PathVariable int id,@RequestBody ClaimRequestDto claimRequestDto){
        try{
            return claimService.updateClaim(id,claimRequestDto);
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @DeleteMapping("/delete_claim/{id}")
    public String deleteClaim(@PathVariable int id){
        try{
            return claimService.deleteClaim(id);
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
