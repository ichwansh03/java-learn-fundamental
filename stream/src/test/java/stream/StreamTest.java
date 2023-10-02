package stream;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    void testStreamValidate(){
        Stream<String> stream = Stream.of("Ichwan", "Sholihin", "Joko", "Widodo");
        stream.forEach(System.out::println);

        Stream<Integer> arrStream = Stream.of(1,2,3,4,5,6,78,90)
                .filter(values -> values % 2 == 0)
                .sorted();

        arrStream.forEach(System.out::println);

    }

    @Test
    void testCollectionStream(){
        Collection<Integer> collect = List.of(12,3,34,354,5,6);
        Stream<Integer> intStream = collect.stream();

        intStream.forEach(System.out::println);
    }
}
