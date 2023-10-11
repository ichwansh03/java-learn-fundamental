package org.example;

import jakarta.validation.constraints.NotBlank;
import org.example.custom.CheckPassword;

@CheckPassword(message = "password must be same with confirm password")
public class Register {

    @NotBlank(message = "username cannot blank")
    private String username;

    @NotBlank(message = "password cannot blank")
    private String password;

    @NotBlank(message = "confirm password cannot blank")
    private String confirmPassword;

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
