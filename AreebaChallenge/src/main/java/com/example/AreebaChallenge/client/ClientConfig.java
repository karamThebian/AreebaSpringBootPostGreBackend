package com.example.AreebaChallenge.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client karam= new Client(1L,"karamthebian","81615542","mazraa");
            Client client1= new Client("client1","81615542","beirut");



            repository.saveAll(
                    List.of(karam,client1)
        );

        };
    }
}
