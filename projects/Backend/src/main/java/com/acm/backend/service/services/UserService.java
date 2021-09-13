package com.acm.backend.service.services;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.model.SignUpForm;

public interface UserService {
    Person createUser(SignUpForm signUpForm);
}
