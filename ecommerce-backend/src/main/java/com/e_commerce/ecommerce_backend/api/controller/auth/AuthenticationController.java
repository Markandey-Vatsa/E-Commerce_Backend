package com.e_commerce.ecommerce_backend.api.controller.auth;
import com.e_commerce.ecommerce_backend.Service.userService;
import com.e_commerce.ecommerce_backend.api.Exception.UserAlreadyExistsException;
import com.e_commerce.ecommerce_backend.api.model.RegistrationBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    userService userRegistration;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            userRegistration.registerUser(registrationBody);
        }catch (UserAlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
