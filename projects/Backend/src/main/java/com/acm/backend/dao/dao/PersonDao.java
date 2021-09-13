package com.acm.backend.dao.dao;

import com.acm.backend.dao.entity.Person;

public interface PersonDao {
    public Person addPerson(Person person);
    public Person getPersonByUserName(String userName);
    public Person getPersonByEmail(String email);
    //public Person getPersonByResetToken(String resetToken);
}
