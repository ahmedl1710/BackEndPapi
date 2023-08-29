package com.tn.papibackend;

import com.tn.papibackend.entity.Role;
import com.tn.papibackend.entity.User;
import com.tn.papibackend.service.userService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class PapiBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(PapiBackEndApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(userService userserv)
    {
        LocalDate datt = LocalDate.of(1990, 5, 15);
        return args->{
           userserv.saveRole(new Role(null,"ROLE_USER"));
            userserv.saveRole(new Role(null,"ROLE_MANAGER"));
            userserv.saveRole(new Role(null,"ROLE_ADMIN"));
            userserv.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userserv.saveUser(new User((Long) null,"Ahmed marzouk","marzouk.ahmed@esprit.tn","1234", 51157780L,datt,"ahmedl17",new HashSet<>(),new HashSet<>(),new HashSet<>(),new HashSet<>()));
            userserv.saveUser(new User((Long) null,"nada marzouk","marzouk.nada@esprit.tn","56789", 51157780L,datt,"nadal17",new HashSet<>(),new HashSet<>(),new HashSet<>(),new HashSet<>()));
            userserv.saveUser(new User((Long) null,"mohamed marzouk","mohamed.ahmed@esprit.tn","4321", 51157780L,datt,"mohamedl17",new HashSet<>(),new HashSet<>(),new HashSet<>(),new HashSet<>()));

            userserv.addRoleToUser("ahmedl17","ROLE_SUPER_ADMIN");
            userserv.addRoleToUser("ahmedl17","ROLE_MANAGER");
            userserv.addRoleToUser("ahmedl17","ROLE_USER");
            userserv.addRoleToUser("mohamedl17","ROLE_ADMIN");
            userserv.addRoleToUser("nadal17","ROLE_MANAGER");
        };
    }

}
