package com.e_commerce.ecommerce_backend.Service;


import com.e_commerce.ecommerce_backend.Entities.Localuser;
import com.e_commerce.ecommerce_backend.Entities.interactionRepos.LocalUserRepo;
import com.e_commerce.ecommerce_backend.api.Exception.UserAlreadyExistsException;
import com.e_commerce.ecommerce_backend.api.model.RegistrationBody;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class userService {

    @Autowired
    LocalUserRepo userRepo;


//    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Localuser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        Localuser user = new Localuser();

//        user.setfirstName(registrationBody.getfirstName());
//        user.setEmail(registrationBody.getEmail());
//
////        TODO -> ENCODE PASSWORD
//        user.setPassword(registrationBody.getPassword());
//
//
//        user.setLast_name(registrationBody.getLast_name());


        if(userRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() || userRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }


        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(registrationBody.getPassword());
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        user.setCreatedAt(LocalDateTime.now());

        user = userRepo.save(user);

        return user;

    }
}
