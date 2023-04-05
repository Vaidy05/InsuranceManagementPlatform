package com.example.InsuranceManagementPlatform.Controller;

import com.example.InsuranceManagementPlatform.Model.Client;
import com.example.InsuranceManagementPlatform.RequestDto.ClientRequestDto;
import com.example.InsuranceManagementPlatform.ResponseDto.ClientResponseDto;
import com.example.InsuranceManagementPlatform.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/get_all_clients")
    public List<ClientResponseDto> getAllClients(){
        try{
            return clientService.getAllClients();
        }
        catch (Exception e){
            return null;
        }
    }

    @GetMapping("/get_client_by_id/{id}")
    public ClientResponseDto getClientById(@PathVariable int id){
        try{
            return clientService.getClientById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping("/add_client")
    public String addClient(@RequestBody ClientRequestDto clientRequestDto){
        try{
            return clientService.addClient(clientRequestDto);
        }
        catch (Exception e){
            return e.toString();
        }
    }

    @PutMapping("/update_client/{id}")
    public String updateClient(@PathVariable int id,@RequestBody ClientRequestDto clientRequestDto){
        try{
            return clientService.updateClient(id,clientRequestDto);
        }
        catch(Exception e){
            return e.toString();
        }
    }

    @DeleteMapping("/delete_client/{id}")
    public String deleteClient(@PathVariable int id){
        try{
            return clientService.deleteClient(id);
        }
        catch (Exception e){
            return e.toString();
        }
    }

}
