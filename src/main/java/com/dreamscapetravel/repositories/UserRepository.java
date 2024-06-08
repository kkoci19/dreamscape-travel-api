package com.dreamscapetravel.repositories;

import com.dreamscapetravel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByFirstName(String firstName);
    Optional<User> findByEmail(String email);
    Optional<User> findOneByEmailAndPassword(String email, String password);
}
