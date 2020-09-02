package com.contact.contact.DAO;

import com.contact.contact.Model.Contact;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ContactDAO implements IContactDAO<Contact> {

    private List<Contact> contactList = new ArrayList<>();

    @Override
    public Optional<Contact> get(int id) {
        return  Optional.ofNullable(contactList.get(id));
    }

    @Override
    public Collection<Contact> getAll() {
        return contactList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public int save(Contact contact) {
        contactList.add(contact);
        int index = contactList.size() - 1;
        contact.setId(index);
        return index;
    }

    @Override
    public void update(Contact contact) {
        contactList.set(contact.getId(), contact);
    }

    @Override
    public void delete(Contact contact) {
        contactList.set(contact.getId(), null);
    }
}
