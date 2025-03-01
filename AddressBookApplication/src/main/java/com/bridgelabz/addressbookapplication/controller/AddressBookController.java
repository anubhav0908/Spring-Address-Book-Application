package com.bridgelabz.addressbookapplication.controller;

import com.bridgelabz.addressbookapplication.dto.AddressBookDTO;
import com.bridgelabz.addressbookapplication.model.AddressBook;
import com.bridgelabz.addressbookapplication.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.addContact(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/{index}")
    public ResponseEntity<Object> getContactByIndex(@PathVariable int index) {
        AddressBook contact = service.getContactByIndex(index);
        return (contact != null) ? ResponseEntity.ok(contact) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{index}")
    public ResponseEntity<String> updateContact(@PathVariable int index, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.updateContact(index, dto));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity<String> deleteContact(@PathVariable int index) {
        return ResponseEntity.ok(service.deleteContact(index));
    }
}
