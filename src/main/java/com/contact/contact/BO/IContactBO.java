package com.contact.contact.BO;

import java.util.Collection;
import java.util.Optional;

public interface IContactBO<T> {
    Optional<T> get(int id);
    Collection<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
