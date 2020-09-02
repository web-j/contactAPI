package com.contact.contact.DAO;

import com.contact.contact.Model.Contact;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Transactional
public class ContactDAO implements IContactDAO<Contact> {

    private Contact contactR = new Contact();

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Contact> get(int id) {
        return  Optional.ofNullable(this.entityManager.find(Contact.class, id));
    }

    @Override
    public Collection<Contact> getAll() {
        return this.entityManager.createQuery("SELECT a FROM Contact a", Contact.class).getResultList();
    }

    @Override
    public void save(Contact contact) {
        this.entityManager.persist(contact);
    }

    @Override
    public void update(Contact contact) {
        this.entityManager.merge(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactR = this.entityManager.find(Contact.class, contact.getId());
        this.entityManager.remove(contactR);
    }
}
