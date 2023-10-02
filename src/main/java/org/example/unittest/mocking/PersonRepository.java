package org.example.unittest.mocking;

public interface PersonRepository {

    Person findById(String id);

    void insert(Person person);
}
