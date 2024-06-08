package com.dreamscapetravel.services;

import com.dreamscapetravel.dto.user.UserLogin;
import com.dreamscapetravel.dto.user.UserRead;
import com.dreamscapetravel.dto.user.UserRegister;
import com.dreamscapetravel.entities.User;
import com.dreamscapetravel.repositories.UserRepository;
import com.dreamscapetravel.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;


    public User saveUser(UserRegister userRegister) {
        User user = new User(
                userRegister.getFirstName(),
                userRegister.getLastName(),
                userRegister.getPhone(),
                userRegister.getUsername(),
                userRegister.getPassword()
        );
        return userRepository.save(user);
    }

//    public LoginResponse loginUser(UserLogin userLogin) {
//        String msg = "";
//        Optional<User> user1 = userRepository.findByEmail(userLogin.getEmail());
//        if (user1 != null) {
//            String password = userLogin.getPassword();
//            String encodedPassword = user1.get().getPassword();
//            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
//            if (isPwdRight) {
//                Optional<User> user = userRepository.findOneByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
//                if (user.isPresent()) {
//                    return new LoginResponse("Login success", true);
//                } else {
//                    return new LoginResponse("Login failed", false);
//                }
//            } else {
//                return new LoginResponse("Incorrect password", false);
//            }
//        } else {
//            return new LoginResponse("Email not registered", false);
//        }
//
//    }


    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }
}
