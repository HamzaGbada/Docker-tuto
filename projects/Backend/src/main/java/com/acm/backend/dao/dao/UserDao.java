package com.acm.backend.dao.dao;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.User;

public interface UserDao {
    public User addUser(User user);
    boolean IsExistsByUserName(String username);
    public User getUserByUserName(String userName);
    public User getUserByEmail(String email);
}
