package net.Skillspire.products;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Addresses")


public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    public Address() {

    }


    public Address(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address: " + address;
    }
    //Assigning the OneToOne between the tables and the fetch type
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Customer customer;
}
