package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

    @NotBlank(message = "name cannot blank")
    private String name;

    @NotBlank(message = "NIP cannot blank")
    @Size(max = 8, message = "NIP length cannot more than 8 characters")
    private String nip;

    @NotNull(message = "address cannot null")
    @Valid
    private Address address;

    public Student() {
    }

    public Student(String name, String nip) {
        this.name = name;
        this.nip = nip;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }

    public void lesson(@NotBlank(message = "subject cannot blank") String subject){
        System.out.println("you took subject "+subject);
    }

    @NotBlank(message = "class code cannot blank")
    public String classCode(){
        return nip;
    }
}
