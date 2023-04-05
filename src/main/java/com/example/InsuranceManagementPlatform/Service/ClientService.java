package com.example.InsuranceManagementPlatform.Service;

import com.example.InsuranceManagementPlatform.Model.Claim;
import com.example.InsuranceManagementPlatform.Model.Client;
import com.example.InsuranceManagementPlatform.Model.InsurancePolicy;
import com.example.InsuranceManagementPlatform.Repository.ClaimRepository;
import com.example.InsuranceManagementPlatform.Repository.ClientRepository;
import com.example.InsuranceManagementPlatform.Repository.PolicyRepository;
import com.example.InsuranceManagementPlatform.RequestDto.ClientRequestDto;
import com.example.InsuranceManagementPlatform.ResponseDto.ClientResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    ClaimRepository claimRepository;

    public List<ClientResponseDto> getAllClients(){
        try {
            List<Client> clientList = clientRepository.findAll();
            List<ClientResponseDto> clientResponseDtoList = new ArrayList<>();
            for(Client client : clientList){
                ClientResponseDto clientResponseDto = new ClientResponseDto(client.getName(),client.getDob(),client.getAddress(),client.getContact_info());
                clientResponseDtoList.add(clientResponseDto);
            }

            return clientResponseDtoList;
        }
        catch(Exception e){
            return null;
        }
    }

    public ClientResponseDto getClientById(int id){
        try{
            Client client = clientRepository.findById(id).get();
            ClientResponseDto clientResponseDto = new ClientResponseDto(client.getName(),client.getDob(),client.getAddress(),client.getContact_info());
            return clientResponseDto;
        }
        catch(Exception e){
            return null;
        }
    }

    public String addClient(ClientRequestDto clientRequestDto){
        try{
            Client client = new Client(clientRequestDto.getName(),clientRequestDto.getDob(),clientRequestDto.getAddress(),clientRequestDto.getContact_info());
            clientRepository.save(client);
            return "Client successfully added";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    public String updateClient(int id,ClientRequestDto clientRequestDto){
        try{
            Client client = clientRepository.findById(id).get();

            client.setName(clientRequestDto.getName());
            client.setDob(clientRequestDto.getDob());
            client.setAddress(clientRequestDto.getAddress());
            client.setContact_info(clientRequestDto.getContact_info());

            clientRepository.save(client);
            return "Client successfully updated";
        }
        catch (Exception e){
            return e.toString();
        }
    }

    public String deleteClient(int id){
        try{
            Client client = clientRepository.findById(id).get();

            List<InsurancePolicy> policyList = client.getPolicyList();

            List<Claim> claimList = client.getClaimList();

            clientRepository.delete(client);
            claimRepository.deleteAll(claimList);
            policyRepository.deleteAll(policyList);

            return "Client successfully deleted";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
