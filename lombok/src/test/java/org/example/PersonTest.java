package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PersonTest {

    @Test
    void testPerson() {

        ArrayList<String> list = new ArrayList<>();
        list.add("Coding");
        list.add("Reading");
        list.add("Writing");

        Person person = new Person();
        person.setId("123A");
        person.setName("Ichwan");
        person.setAge(22);
        person.setHobbies(list);
    }

    @Test
    void testPersonWithBuilder(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Coding");
        list.add("Reading");
        list.add("Writing");

        var person = Person.builder()
                .id("123A")
                .name("Ichwan")
                .age(22)
                .hobby("Coding").hobby("Reading").hobby("Writing")
                .build();

        System.out.println(person);
    }
}
