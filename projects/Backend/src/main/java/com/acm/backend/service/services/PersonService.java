package com.acm.backend.service.services;

import com.acm.backend.dao.entity.Person;

public interface PersonService {
    Person getPersonByUserName(String username);

}

