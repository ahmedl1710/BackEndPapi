package com.tn.papibackend.service;

import com.tn.papibackend.entity.User;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.userRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl extends IGenericServiceImp<User,Long> implements IUserService{


    private userRepo userepo;
}
