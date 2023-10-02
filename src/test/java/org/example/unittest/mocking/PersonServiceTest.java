package org.example.unittest.mocking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository repository;
    private PersonService service;

    @BeforeEach
    void setUp(){
        service = new PersonService(repository);
    }

    @Test
    void testIdNotFound(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getById("Not Found"));
    }

    @Test
    void testIdSuccess(){
        //behavior
        Mockito.when(repository.findById("ichwan")).thenReturn(new Person("ichwan", "Ichwan"));

        var person = service.getById("ichwan");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("ichwan", person.getId());
        Assertions.assertEquals("Ichwan", person.getName());
    }

    //verify di method non-return value
    @Test
    void testInsertPersonSuccess(){
        var person = service.register("Ichwan");
        assertNotNull(person);

        assertEquals("Ichwan", person.getName());
        assertNotNull(person.getId());

        Mockito.verify(repository, Mockito.times(1)).insert(new Person(person.getId(), "Ichwan"));
    }
}