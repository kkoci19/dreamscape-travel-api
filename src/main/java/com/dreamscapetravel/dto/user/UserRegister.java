package com.dreamscapetravel.dto.user;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String username;
    protected String password;
    protected String repeatPassword;
}
