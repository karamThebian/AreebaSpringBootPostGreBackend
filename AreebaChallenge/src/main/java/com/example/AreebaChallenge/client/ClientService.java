package com.example.AreebaChallenge.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
@Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {

        return clientRepository.findAll();

    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByName(client.getName());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
         clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if(!exists){
            throw new IllegalStateException("client with id "+clientId+" does not exist");
        }
        clientRepository.deleteById(clientId);
    }
    @Transactional
    public void updateClient(Long clientId, String name,String phoneNumber, String address) {
        Client client = clientRepository.findById(clientId).orElseThrow(()-> new IllegalStateException("client with id "+clientId+" does not exist"));
        if (name!=null && name.length()>0 && !Objects.equals(client.getName(),name)){
            client.setName(name);
        }
        if (address!=null && address.length()>0 && !Objects.equals(client.getAddress(),address)){
            client.setAddress(address);
        }
        if (phoneNumber!=null && phoneNumber.length()>0 && !Objects.equals(client.getPhoneNumber(),phoneNumber)){
            client.setPhoneNumber(phoneNumber);
        }


    }



    public List<Client> searchClientsByName(String name) {
        List<Client> clients =new ArrayList<>();

        if (name!=null && name.length()>0){
            clients.add(clientRepository.findClientByName(name).get());
    }
        return clients;
    }

    public List<Client> searchClientsByAddress(String address) {
        List<Client> clients =new ArrayList<>();

        if (address!=null && address.length()>0){
            clients.add(clientRepository.findClientByAddress(address).get());
        }
        return clients;
    }

    public List<Client> searchClientsByPhoneNumber(String phoneNumber) {
        List<Client> clients =new ArrayList<>();

        if (phoneNumber!=null && phoneNumber.length()>0){
            clients.add(clientRepository.findClientByPhoneNumber(phoneNumber).get());
        }
        return clients;
    }

}



