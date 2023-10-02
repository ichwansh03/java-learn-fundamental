package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void testMock(){
        List list = Mockito.mock(List.class);

        //membuat object tiruan
        Mockito.when(list.get(12)).thenReturn("Ahmad");
        Mockito.when(list.get(50)).thenReturn("Abdul");
        Mockito.when(list.get(100)).thenReturn("Aziz");

        System.out.println(list.get(12));
        System.out.println(list.get(1));

        //berapa kali object tiruan mock dipanggil?
        Mockito.verify(list, Mockito.times(1)).get(1);
    }
}
