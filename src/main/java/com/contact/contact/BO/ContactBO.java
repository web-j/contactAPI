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

    @Override
    public Optional<Contact> get(int id) {
        return contactDAO.get(id);
    }

    @Override
    public Collection<Contact> getAll() {
        return contactDAO.getAll();
    }

    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDAO.update(contact);
    }

    @Override
    public void delete(int id) {
        contactDAO.delete(id);
    }

}
