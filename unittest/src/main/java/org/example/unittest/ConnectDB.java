package org.example.unittest;

public class ConnectDB {

    public boolean validate(String user, String password){
        return user.matches("root") && password.matches("");
    }

    public boolean connect(String host, Integer port){
        if (host.matches("localhost") && port != 8080){
            throw new IllegalArgumentException("cannot access port 8080");
        } else {
            return true;
        }
    }
}
