package org.example.unittest;

import org.junit.Assert;
import org.junit.Test;

public class ConnectDBTest {

    ConnectDB connectDB = new ConnectDB();

    @Test
    public void testValidateSuccess(){

        var result = connectDB.validate("root","");

        Assert.assertTrue("Validation successfully", result);
    }

    @Test
    public void testValidateFailed(){

        var result = connectDB.validate("","");

        Assert.assertFalse("Validation fail", result);
    }

    @Test
    public void testConnectSuccess(){
        var connect = connectDB.connect("localhost",8080);
        Assert.assertTrue("Database connected", connect);
    }

    @Test
    public void testConnectFailed(){
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            connectDB.connect("localhost",80);
        });
    }
}