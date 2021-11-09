package com.example.AreebaChallenge.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/client")
public class ClientController {
    private final ClientService clientservice;

    @Autowired
    public ClientController(ClientService clientservice) {
        this.clientservice = clientservice;
    }

    @GetMapping
    public List<Client> getClients() {
return clientservice.getClients();
    }
    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        clientservice.addNewClient(client);

    }
    @DeleteMapping(path="{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId){
        clientservice.deleteClient(clientId);

    }
    @PutMapping(path="{clientId}")
    public void updateClient(@PathVariable("clientId") Long clientId,@RequestParam(required = false) String name,@RequestParam(required = false) String address,@RequestParam(required = false) String phoneNumber){
    clientservice.updateClient(clientId,name,phoneNumber,address);
    }
    @RequestMapping(path="/name/{name}")
    public List<Client> searchClientsByName(@PathVariable("name") String name){
        return clientservice.searchClientsByName(name);
    }

    @RequestMapping(path="/address/{address}")
    public List<Client> searchClientsByAddress(@PathVariable("address") String address){
        return clientservice.searchClientsByAddress(address);
    }

    @RequestMapping(path="/phoneNumber/{phoneNumber}")
    public List<Client> searchClientsByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        return clientservice.searchClientsByPhoneNumber(phoneNumber);
    }

    }

