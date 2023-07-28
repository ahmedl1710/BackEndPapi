package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
