package com.bridgelabz.addressbookapplication.controller;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private List<AddressBook> addressBookList = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestBody AddressBookDTO dto) {
        AddressBook contact = new AddressBook(dto);
        addressBookList.add(contact);
        return ResponseEntity.ok("Contact added successfully!");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressBookList);
    }
}
