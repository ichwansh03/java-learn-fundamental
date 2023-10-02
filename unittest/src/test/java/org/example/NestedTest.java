package org.example;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class NestedTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("When queue is created")
    public class CreatedQueue {

        @BeforeEach
        void setUp(){
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When queue is added, size must be one")
        void addedQueue(){
            queue.add("Ichwan");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("When queue is added, size must be two")
        void addedMoreQueue(){
            queue.add("Ichwan");
            queue.add("Sholihin");
            Assertions.assertEquals(2, queue.size());
        }

        @Test
        @DisplayName("When queue is delete all, size back to null")
        void deleteQueue(){
            queue.removeAll(queue);
            Assertions.assertEquals(0, queue.size());
        }
    }
}
