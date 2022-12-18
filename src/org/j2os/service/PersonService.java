package org.j2os.service;

import org.j2os.entity.Person;

public interface PersonService {
    String save(Person person) throws Exception;

    String update(Person person) throws Exception;

    String remove(Person person) throws Exception;

    String findAll() throws Exception;
}
