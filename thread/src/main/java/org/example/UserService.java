package org.example;

public class UserService {

    private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setUser(String user){
        threadLocal.set(user);
    }

    public void doAction(){
        String name = threadLocal.get();
        System.out.println("act -> "+name);
    }
}
