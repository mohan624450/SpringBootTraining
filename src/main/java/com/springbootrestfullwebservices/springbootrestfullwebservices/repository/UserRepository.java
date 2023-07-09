package com.springbootrestfullwebservices.springbootrestfullwebservices.repository;
import com.springbootrestfullwebservices.springbootrestfullwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByMail(String mail);
}
