package com.contact.contact.BO;

import java.util.Collection;
import java.util.Optional;

public interface IContactBO<T> {
    Optional<T> getContactId(int id);
    Collection<T> getAllContact();
    int saveContact(T t);
}
