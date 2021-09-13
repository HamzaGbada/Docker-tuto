package com.acm.backend.api;

import com.acm.backend.configuration.security.jwt.JwtProvider;
import com.acm.backend.configuration.security.services.UserPrincipale;
import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.Role;
import com.acm.backend.dao.model.JwtResponse;
import com.acm.backend.dao.model.LoginForm;
import com.acm.backend.service.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtProvider jwtProvider;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);

        JwtResponse jwtResponse=new JwtResponse(jwt);
        UserPrincipale userDetails = (UserPrincipale) authentication.getPrincipal();
        Person user = personService.getPersonByUserName(loginRequest.getUsername());
        Role role = user.getRoles().get(0);
        jwtResponse.setTokenType(role.getRoleName());

        return ResponseEntity.ok(jwtResponse);

    }
}
