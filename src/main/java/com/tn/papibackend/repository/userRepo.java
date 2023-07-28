package com.tn.papibackend.repository;

import com.tn.papibackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Long> {

    User findByUsername(String name);
}
