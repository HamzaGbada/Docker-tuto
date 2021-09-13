package com.acm.backend.service.services.implementation;

import com.acm.backend.dao.dao.PersonDao;
import com.acm.backend.dao.entity.Person;
import com.acm.backend.service.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Override
    public Person getPersonByUserName(String username) {
        return personDao.getPersonByUserName(username);
    }
}
