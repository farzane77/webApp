package org.j2os.service;


import org.j2os.entity.Person;
import org.j2os.repository.PersonDA;

import java.util.List;

import static org.j2os.common.json.JSONProvider.toJSon;

public class PersonServiceImpl implements PersonService {
    private static final PersonServiceImpl PERSON_SERVICE = new PersonServiceImpl();

    private PersonServiceImpl() {
    }

    public static PersonServiceImpl getInstance() {
        return PERSON_SERVICE;
    }

    @Override
    public String save(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.insert(person);
            personDA.commit();
        }
        return findAll();
    }

    @Override
    public String update(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.update(person);
            personDA.commit();
        }
        return findAll();
    }

    @Override
    public String remove(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.delete(person);
            personDA.commit();
        }
        return findAll();
    }

    @Override
    public String findAll() throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            List<Person> personList = personDA.selectAll();
            return toJSon(personList);
        }
    }
}
