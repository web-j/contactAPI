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
    private IContactBO contactBO;

    @GetMapping(value = "/{id}")
    public Optional<Contact> getId(@PathVariable("id") int id) {
        return contactBO.get(id);
    }

    @GetMapping
    public Collection<Contact> getAll() {
        return contactBO.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Contact contact) {
        contactBO.save(contact);
    }

    @PutMapping
    public void update(@RequestBody Contact contact) {
        contactBO.update(contact);
    }

    @DeleteMapping
    public void delete(@RequestBody Contact contact) {
        contactBO.delete(contact);
    }
}
