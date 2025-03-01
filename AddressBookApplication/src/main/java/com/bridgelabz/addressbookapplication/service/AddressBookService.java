package com.bridgelabz.addressbookapplication.service;



import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private List<AddressBook> addressBookList = new ArrayList<>();

    public String addContact(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(dto);
        addressBookList.add(contact);
        return "Contact added successfully!";
    }

    public List<AddressBook> getAllContacts() {
        return addressBookList;
    }
}
