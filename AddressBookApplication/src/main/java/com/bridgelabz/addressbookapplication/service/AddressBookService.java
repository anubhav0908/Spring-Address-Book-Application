package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();

    public String addContact(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(dto);
        addressBookList.add(contact);
        return "Contact added successfully!";
    }

    public List<AddressBook> getAllContacts() {
        return addressBookList;
    }

    public AddressBook getContactById(int index) {
        if (index >= 0 && index < addressBookList.size()) {
            return addressBookList.get(index);
        }
        return null;
    }

    public String updateContact(int index, AddressBookDTO dto) {
        if (index >= 0 && index < addressBookList.size()) {
            AddressBook contact = new AddressBook(dto);
            addressBookList.set(index, contact);
            return "Contact updated successfully!";
        }
        return "Contact not found!";
    }

    public String deleteContact(int index) {
        if (index >= 0 && index < addressBookList.size()) {
            addressBookList.remove(index);
            return "Contact deleted successfully!";
        }
        return "Contact not found!";
    }


}
