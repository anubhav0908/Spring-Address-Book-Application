package com.bridgelabz.addressbookapplication.model;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "address_book")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    public AddressBook() {}

    public AddressBook(AddressBookDTO dto) {
        this.name = dto.name;
        this.address = dto.address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
