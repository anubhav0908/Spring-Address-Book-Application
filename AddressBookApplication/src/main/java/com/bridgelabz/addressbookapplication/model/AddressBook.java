package com.bridgelabz.addressbookapplication.model;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;

public class AddressBook {
    private String name;
    private String address;

    public AddressBook(AddressBookDTO dto) {
        this.name = dto.name;
        this.address = dto.address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
