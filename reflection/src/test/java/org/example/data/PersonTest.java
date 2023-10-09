package org.example.data;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

class PersonTest {

    @Test
    void testCreateClass() {
        Class<Person> personClass = Person.class;

        System.out.println(personClass.descriptorString());
        System.out.println(personClass.getComponentType());
        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(personClass.getMethods()));
        System.out.println(personClass.getCanonicalName());
        System.out.println(Arrays.toString(personClass.getClasses()));
        System.out.println(Arrays.toString(personClass.getDeclaredFields()));
    }

    @Test
    void testManipulateField() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);

        Person person = new Person("Ichwan", "ichwan@test.com", 22);
        name.set(person, "Mahmud");
        System.out.println(person.getName());
    }
}