package com.example.AreebaChallenge.client;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ClientRepository extends JpaRepository<Client,Long> {

   @Query("SELECT c FROM Client c WHERE c.id=?1")
   Optional<Client> findClientById(Long id);



   @Query("SELECT c FROM Client c WHERE c.name=?1")
   Optional<Client> findClientByName(String name);

   @Query("SELECT c FROM Client c WHERE c.address=?1")
   Optional<Client> findClientByAddress(String address);

   @Query("SELECT c FROM Client c WHERE c.phoneNumber=?1")
   Optional<Client> findClientByPhoneNumber(String phoneNumber);

}
