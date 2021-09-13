package com.acm.backend.dao.repository;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    public Person findByUserName(String username);
    public Person findByEmail(String email);
    //public Person findByResetToken(String resetToken);
}
