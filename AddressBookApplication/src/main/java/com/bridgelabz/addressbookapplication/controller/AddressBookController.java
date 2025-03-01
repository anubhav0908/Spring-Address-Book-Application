package com.bridgelabz.addressbookapplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private Map<Integer, String> addressBook = new HashMap<>();

    @GetMapping("/getAll")
    public ResponseEntity<Map<Integer, String>> getAllContacts() {
        return ResponseEntity.ok(addressBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return addressBook.containsKey(id) ?
                ResponseEntity.ok(addressBook.get(id)) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestParam int id, @RequestParam String name) {
        addressBook.put(id, name);
        return ResponseEntity.ok("Contact added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id, @RequestParam String name) {
        if (addressBook.containsKey(id)) {
            addressBook.put(id, name);
            return ResponseEntity.ok("Contact updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        if (addressBook.containsKey(id)) {
            addressBook.remove(id);
            return ResponseEntity.ok("Contact deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
