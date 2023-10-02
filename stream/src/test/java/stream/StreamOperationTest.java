package stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperationTest {

    @Test
    void testStreamOperation(){
        List<String> names = List.of("anies", "prabowo", "cak imin");
        Stream<String> stream = names.stream();

        Stream<String> streamUpper = stream.map(String::toUpperCase);
        streamUpper.forEach(System.out::println);

        names.forEach(System.out::println);
    }

    @Test
    void testStreamPipeline(){
        List<Integer> numbers = List.of(1,12,23,334,45,6,5,67,67,867,5,20);

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(value -> value * 2)
                .forEach(System.out::println);
    }

    @Test
    void testTransformationOperationsMap(){
        //transform from string to integer
        List.of("Ichwan","Sholihin","Abdullah").stream()
                .map(String::toLowerCase)
                .map(String::length)
                .forEach(System.out::println);
    }

    @Test
    void testTransformationOperationFlatMap(){
        List.of("Ichwan","Sholihin","Abdullah").stream()
                .map(String::toUpperCase)
                .flatMap(upper -> Stream.of(upper, upper, upper.length()))
                .forEach(System.out::println);
    }

    @Test
    void testRetrieveOperation(){
        List.of("Ichwan","Sholihin","Abdullah", "Ali", "Mubarok", "Budi").stream()
                .limit(5)
                .skip(1)
                .forEach(System.out::println);

        List.of("Ichwan","Sholihin","Abdullah", "Ali", "Mubarok", "Budi").stream()
                .takeWhile(name -> name.length() > 5)
                .forEach(System.out::println);
    }

    @Test
    void testSortedOperation(){
        List.of("Ichwan","Sholihin","Abdullah", "Ali", "Mubarok", "Budi").stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testAggregateOperation(){
        List.of("Ichwan","Sholihin","Abdullah", "Ali", "Mubarok", "Budi").stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

//        Stream.of("Ichwan","Sholihin","Abdullah", "Ali", "Mubarok", "Budi")
//                .min(Comparator.naturalOrder())
//                .ifPresent(System.out::println);
    }

    @Test
    void testSumData(){
        var result = Stream.of(1,2,3,4,5,6,7,8)
                .reduce(0, Integer::sum);

        System.out.println(result);
    }

    @Test
    void testCheckOperation(){
        boolean match = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .anyMatch(value -> value % 2 == 0);

        System.out.println(match);
    }
}
