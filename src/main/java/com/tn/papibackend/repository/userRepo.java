package com.tn.papibackend.repository;

import com.tn.papibackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userRepo extends JpaRepository<User,Long> {

    User findByUsername(String name);

    @Query("SELECT u FROM User u INNER JOIN u.roles r WHERE r.name = :roleName")
    List<User> findUsersByRoleName(@Param("roleName") String roleName);
}
