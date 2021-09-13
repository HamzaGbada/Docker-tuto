package com.acm.backend.api;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.model.SignUpForm;
import com.acm.backend.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerPatient(@RequestBody SignUpForm signUpForm) {
        Person user = userService.createUser(signUpForm);
        if (user == null)
            return ResponseEntity.ok("bad registration!!"+ signUpForm);
        return ResponseEntity.ok("registred");
    }
}
