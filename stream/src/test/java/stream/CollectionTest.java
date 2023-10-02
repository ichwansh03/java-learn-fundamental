package stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTest {

    Stream<String> getStream(){
        return Stream.of("Ichwan","Sholihin","Abdul","Aziz");
    }

    @Test
    void testStreamCollector(){
        Set<String> set = getStream().collect(Collectors.toSet());
        List<String> list = getStream().toList();
        Map<String, Integer> map = getStream().collect(Collectors.toMap( key -> key, String::length));
        System.out.println(map);
    }
    
    @Test
    void testCollectorsGroupingBy(){
        Map<String, List<Integer>> maps = Stream.of(1,2,3,4,5,6,7,8)
                .collect(Collectors.groupingBy(number -> number > 5 ? "Big" : "Small"));

        System.out.println(maps);

        Map<String, List<String>> collect = getStream().collect(Collectors.groupingBy(name -> name.length() > 5 ? "Panjang" : "Pendek"));
        System.out.println(collect);
    }
    
    @Test
    void testCollectorsPartitioningBy(){
        Map<Boolean, List<Integer>> maps = Stream.of(1,2,3,4,5,6,7,8)
                .collect(Collectors.partitioningBy(number -> number > 5));

        System.out.println(maps);

    }
}
