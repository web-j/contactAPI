package com.contact.contact.Controller;

import com.contact.contact.BO.IContactBO;
import com.contact.contact.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private IContactBO service;

    @GetMapping
    public Collection<Contact> getAll() {
        return service.getAllContact();
    }

    @GetMapping(value = "/{id}")
    public Optional<Contact> getId(@PathVariable("id") int id) {
        return service.getContactId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int create(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }
}
