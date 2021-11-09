package com.example.AreebaChallenge.client;

import javax.persistence.*;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(name="client_sequence",sequenceName = "client_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "client_sequence")

    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    public Client() {
    }

    public Client(Long id,
                  String name,
                  String phoneNumber,
                  String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Client(String name,
                  String phoneNumber,
                  String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
