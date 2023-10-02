package org.example;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

    @Test
    void testRegister(){

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e){
            Assertions.fail(e);
        }
    }
}
