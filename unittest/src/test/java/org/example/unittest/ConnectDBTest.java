package org.example.unittest;

import org.junit.jupiter.api.*;

@Tag("db-unit-test")
@DisplayName("Connection to DB")
public class ConnectDBTest {

    ConnectDB connectDB = new ConnectDB();

    @BeforeAll
    public static void connectAll(){
        System.out.println("Connecting All..");
    }

    @AfterAll
    public static void finishAll(){
        System.out.println("Finished All");
    }

    @BeforeEach
    public void connected(){
        System.out.println("Connecting..");
    }

    @AfterEach
    public void finished(){
        System.out.println("Finished");
    }

    @Test
    @DisplayName("Validation success scenario to DB")
    public void testValidateSuccess(){

        var result = connectDB.validate("root","");

        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateFailed(){

        var result = connectDB.validate("","");

        Assertions.assertFalse(result, "Validation not valid");
    }

    @Test
    public void testConnectSuccess(){
        var connect = connectDB.connect("localhost",8080);
        Assertions.assertTrue(connect,"Successfully connected to DB");
    }

    @Test
    @Disabled
    public void testConnectFailed(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> connectDB.connect("localhost",80));
    }
}