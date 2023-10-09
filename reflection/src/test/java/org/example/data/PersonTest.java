package org.example.data;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

class PersonTest {

    @Test
    void testCreateClass() {
        Class<Person> personClass = Person.class;
        Package personClassPackage = personClass.getPackage();

        System.out.println(personClassPackage.getName());
        System.out.println(Arrays.toString(personClassPackage.getAnnotations()));
        System.out.println(personClass.getSuperclass());
        System.out.println(Modifier.isPublic(personClass.getModifiers()));
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

    @Test
    void testGetMethodParameters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();

        for (Method value: methods){
            System.out.println(value.getName());
        }

        Method setName = personClass.getDeclaredMethod("setName", String.class);

        Person person = new Person("Ichwan", "ichwan@test.com", 22);
        setName.invoke(person,"Abdullah");
    }
}