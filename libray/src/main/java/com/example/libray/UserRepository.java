package com.example.libray;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByPhoneNumber(String phoneNumber);
    Optional<Users> findByUsernameAndPhoneNumber(String username, String phoneNumber);
}
