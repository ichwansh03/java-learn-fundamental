package stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StreamBuilderTest {

    @Test
    void testCreateStreamBuilder(){
        Stream.Builder<String> build = Stream.builder();
        build.accept("Ichwan");

        Stream<String> stream = build.build();
        stream.forEach(System.out::println);

        Stream<Object> builder = Stream
                .builder()
                .add("Ichwan").add("Sholihin")
                .build();

        builder.forEach(System.out::println);
    }
}
