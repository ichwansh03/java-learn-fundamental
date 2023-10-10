package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

    @NotBlank(message = "{name.id.notblank}")
    private String name;

    @NotBlank(message = "{nip.id.notblank}")
    @Size(max = 8, message = "{nip.size.max}")
    private String nip;

    @NotNull(message = "{address.id.notnull}")
    @Valid
    private Address address;

    @Valid
    public Student() {
    }

    @Valid
    public Student(@NotBlank(message = "{name.id.notblank}") String name,@NotBlank(message = "{nip.id.notblank}") String nip, @NotNull(message = "Address cannot null") @Valid Address address) {
        this.name = name;
        this.nip = nip;
        this.address = address;
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

    public void lesson(@NotBlank(message = "{subject.id.notblank}") String subject){
        System.out.println("you took subject "+subject);
    }

    @NotBlank(message = "{class.id.notblank}")
    public String classCode(){
        return nip;
    }
}
