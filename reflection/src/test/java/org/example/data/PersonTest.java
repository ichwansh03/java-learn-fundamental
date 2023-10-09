package org.example.data;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;

class PersonTest {

    @Test
    void testCreateClass() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Package personClassPackage = personClass.getPackage();
        Field age = personClass.getDeclaredField("age");

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
        System.out.println(personClass.getAnnotation(ReflectionInfo.class));
        //khusus get tipe data primitive (int, long, boolean)
        System.out.println(age.getType().isPrimitive());
    }

    @Test
    void testManipulateField() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);

        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);

        Person person = new Person("Ichwan", "ichwan@test.com", 22);
        name.set(person, "Mahmud");
        System.out.println(person.getName());
        System.out.println(age.getInt(person));
    }

    @Test
    void testGetMethodParameters() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();

        Method getActivities = personClass.getDeclaredMethod("getActivities");
        Type type = getActivities.getGenericReturnType();

        if (type instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println(parameterizedType.getRawType());
        }

        for (Method value: methods){
            System.out.println(value.getName());
        }

        Method setName = personClass.getDeclaredMethod("setName", String.class);

        Person person = new Person("Ichwan", "ichwan@test.com", 22);
        setName.invoke(person,"Abdullah");
        System.out.println(person.getName());
    }
}