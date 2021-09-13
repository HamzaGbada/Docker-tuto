package com.acm.backend.dao.dao.implementation;

import com.acm.backend.dao.dao.UserDao;
import com.acm.backend.dao.entity.User;
import com.acm.backend.dao.entity.User;
import com.acm.backend.dao.repository.UserRepository;
import com.acm.backend.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean IsExistsByUserName(String username){return userRepository.existsByUserName(username);}


    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
/*
    @Override
    public User getUserByResetToken(String resetToken) {
        return UserRepository.findByResetToken(resetToken);
    }*/

}
