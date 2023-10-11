package org.example;

import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.UUID;

public class MDCTest {

    @Test
    void testRequestIDWithoutMDC() {

        String reqId = UUID.randomUUID().toString();

        Controller controller = new Controller(new Service(new Repository()));

        controller.save();
    }

    @Test
    void testWithMDC(){
        String reqId = UUID.randomUUID().toString();

        Controller controller = new Controller(new Service(new Repository()));

        MDC.put("reqId", reqId);
        controller.save();

        MDC.remove("reqId");
    }
}
