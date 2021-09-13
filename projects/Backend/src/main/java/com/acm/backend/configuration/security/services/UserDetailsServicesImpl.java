package com.acm.backend.configuration.security.services;

import com.acm.backend.dao.dao.PersonDao;
import com.acm.backend.dao.dao.UserDao;
import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    PersonDao personDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Person person = personDao.getPersonByUserName(username);

        return UserPrincipale.build(person);
    }

}
