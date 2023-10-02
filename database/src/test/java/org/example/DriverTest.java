package org.example;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

    @BeforeAll
    static void testRegister(){
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    void testConnection(){
        String jdbcUrl = "jdbc:mysql://localhost/dbpos";
        String username = "root";
        String password = "";

//        try {
//            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//            System.out.println("Connected successfully");
//            connection.close();
//        } catch (SQLException e){
//            Assertions.fail(e);
//        }

        //try with resource
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected successfully");
        } catch (SQLException e){
            Assertions.fail(e);
        }
    }
}
