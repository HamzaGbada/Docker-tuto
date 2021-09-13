package com.acm.backend.dao.repository;

import com.acm.backend.dao.entity.Person;
import com.acm.backend.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserName(String username);
    public User findByEmail(String email);
    boolean existsByUserName(String username);

}
