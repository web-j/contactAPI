package com.contact.contact.BO;

import com.contact.contact.DAO.IContactDAO;
import com.contact.contact.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Component(value = "ContactBO")
@Service
public class ContactBO implements IContactBO<Contact> {

    @Autowired
    private IContactDAO<Contact> contactDAO;
    private Contact contact = new Contact();

    public Optional<Contact> getContactId(int id) {
        return contactDAO.get(id);
    }

    public Collection<Contact> getAllContact() {
        return contactDAO.getAll();
    }

    public int saveContact(Contact contact) {
        return contactDAO.save(contact);
    }

}
