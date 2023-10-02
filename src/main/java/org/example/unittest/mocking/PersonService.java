package org.example.unittest.mocking;

import java.util.UUID;

public class PersonService {

    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person getById(String id){
        Person person = repository.findById(id);

        if (person != null){
            return person;
        }
        else {
            throw new IllegalArgumentException("Person in id "+id+" not found");
        }
    }

    public Person register(String name){
        var person = new Person(UUID.randomUUID().toString(), name);
        repository.insert(person);
        return person;
    }
}
