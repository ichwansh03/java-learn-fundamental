package org.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    public static final Logger log = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    void loggerTest() {

        log.info("Hello Logger");
        log.error("hayo...");

        log.error("Error Null Pointer Exception", new NullPointerException());
    }
}
