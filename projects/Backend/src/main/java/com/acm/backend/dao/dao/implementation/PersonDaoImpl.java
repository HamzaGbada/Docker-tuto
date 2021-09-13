package com.acm.backend.dao.dao.implementation;

import com.acm.backend.dao.dao.PersonDao;
import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.User;
import com.acm.backend.dao.repository.PersonRepository;
import com.acm.backend.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person addPerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person getPersonByUserName(String userName) {
        return personRepository.findByUserName(userName);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }
/*
    @Override
    public Person getPersonByResetToken(String resetToken) {
        return personRepository.findByResetToken(resetToken);
    }*/
}
